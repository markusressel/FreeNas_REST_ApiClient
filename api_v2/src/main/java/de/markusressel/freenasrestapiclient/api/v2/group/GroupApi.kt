/*
 * Copyright (c) 2019 Markus Ressel
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

package de.markusressel.freenasrestapiclient.api.v2.group

import com.github.kittinunf.result.Result
import com.google.gson.JsonElement

interface GroupApi {

    /**
     * Creates a new group
     *
     */
    suspend fun createGroup(groupId: Int,
                            name: String,
                            sudo: Boolean,
                            allow_duplicate_gid: Boolean,
                            users: List<Int>): Result<JsonElement, Exception>

    /**
     * Deletes a group
     *
     * @param groupId group id
     * @param deleteUsers whether to delete users associated with this group
     */
    suspend fun deleteGroup(groupId: Int, deleteUsers: Boolean? = null): Result<JsonElement, Exception>

    /**
     * Get the next available/free gid.
     *
     */
    suspend fun getNextFreeGroupId(): Result<JsonElement, Exception>

    /**
     * Query a list of groups
     *
     * TODO: query params
     *
     */
    suspend fun getGroups(): Result<JsonElement, Exception>

    /**
     * Updates a group
     *
     * @param groupId group id to update
     */
    suspend fun updateGroup(groupId: Int): Result<JsonElement, Exception>

}