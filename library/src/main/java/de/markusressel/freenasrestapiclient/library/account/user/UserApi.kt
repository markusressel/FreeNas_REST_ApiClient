package de.markusressel.freenasrestapiclient.library.account.user

import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.fuel.core.Response
import com.github.kittinunf.result.Result
import de.markusressel.freenasrestapiclient.library.RequestManager
import io.reactivex.Single

interface UserApi {

    /**
     * Get a list of all users
     */
    fun getUsers(limit: Int = RequestManager.DEFAULT_LIMIT,
                 offset: Int = RequestManager.DEFAULT_OFFSET): Single<List<UserModel>>

    /**
     * Create a new user
     */
    fun createUser(data: UserModel): Single<UserModel>

    /**
     * Update an existing user
     */
    fun updateUser(data: UserModel): Single<UserModel>

    /**
     * Delete a user
     */
    fun deleteUser(user: UserModel): Single<Pair<Response, Result<ByteArray, FuelError>>>

    /**
     * Set a password for a user
     */
    fun setUserPassword(userId: Long,
                        newPassword: String): Single<Pair<Response, Result<ByteArray, FuelError>>>

    /**
     * Get user auxiliary groups
     */
    fun getGroups(userId: Long): Single<Pair<Response, Result<ByteArray, FuelError>>>

    /**
     * Get user auxiliary groups
     */
    fun setGroups(userId: Long,
                  vararg group: String): Single<Pair<Response, Result<ByteArray, FuelError>>>
}