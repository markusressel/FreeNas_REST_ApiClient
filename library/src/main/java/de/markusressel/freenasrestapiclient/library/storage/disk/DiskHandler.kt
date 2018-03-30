package de.markusressel.freenasrestapiclient.library.storage.disk

import com.github.kittinunf.fuel.core.Method
import de.markusressel.freenasrestapiclient.library.RequestManager
import io.reactivex.Single

/**
 * Created by Markus on 09.02.2018.
 */
class DiskHandler(private val requestManager: RequestManager) : DiskApi {

    override fun getDisks(limit: Int, offset: Int): Single<List<DiskModel>> {
        val params = requestManager
                .createLimitOffsetParams(limit, offset)
        return requestManager
                .doRequest("/storage/disk/", params, Method.GET, DiskModel.ListDeserializer())
    }

    override fun updateDisk(data: DiskModel): Single<DiskModel> {
        return requestManager
                .doJsonRequest("/storage/disk/${data.disk_identifier}", Method.PUT, data,
                               DiskModel.SingleDeserializer())
    }

}