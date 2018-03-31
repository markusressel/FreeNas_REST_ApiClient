/*
 * Copyright (c) 2018 Markus Ressel
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons
 * to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package de.markusressel.freenasrestapiclient.library.jails.mountpoint

import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.fuel.core.Method
import com.github.kittinunf.fuel.core.Response
import com.github.kittinunf.result.Result
import de.markusressel.freenasrestapiclient.library.RequestManager
import io.reactivex.Single

/**
 * Created by Markus on 09.02.2018.
 */
class MountpointHandler(private val requestManager: RequestManager) : MountpointApi {

    override fun getMountpoints(limit: Int, offset: Int): Single<List<MountpointModel>> {
        val params = requestManager
                .createLimitOffsetParams(limit, offset)
        return requestManager
                .doRequest("/jails/mountpoints/", params, Method.GET,
                        MountpointModel.ListDeserializer())
    }

    override fun createMountpoint(data: MountpointModel): Single<MountpointModel> {
        return requestManager
                .doJsonRequest("/jails/mountpoints/", Method.POST, data,
                        MountpointModel.SingleDeserializer())
    }

    override fun updateMountpoint(data: MountpointModel): Single<MountpointModel> {
        return requestManager
                .doJsonRequest("/jails/mountpoints/${data.id}/", Method.PUT, data,
                        MountpointModel.SingleDeserializer())
    }

    override fun deleteMountpoint(
            mountpoint: MountpointModel): Single<Pair<Response, Result<ByteArray, FuelError>>> {
        return requestManager
                .doRequest("/jails/mountpoints/${mountpoint.id}/", Method.DELETE)
    }

}