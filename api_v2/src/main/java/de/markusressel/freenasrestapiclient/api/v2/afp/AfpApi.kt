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

package de.markusressel.freenasrestapiclient.api.v2.afp

import de.markusressel.freenasrestapiclient.api.v2.ApiEnum
import de.markusressel.freenasrestapiclient.api.v2.ApiListener

interface AfpApi {

    enum class MapAcl(private val jsonValue: String) : ApiEnum {
        RIGHTS("rights"),
        MODE("mode"),
        NONE("none");

        override fun toJsonValue(): String = jsonValue
    }

    enum class ChmodRequest(private val jsonValue: String) : ApiEnum {
        PRESERVE("preserve"),
        SIMPLE("simple"),
        IGNORE("ignore");

        override fun toJsonValue(): String = jsonValue
    }

    /**
     * Get the AFP sharing config
     *
     * @param listener result listener
     */
    fun getAfpConfig(listener: ApiListener)

    /**
     * Update the AFP sharing config
     */
    fun updateAfpConfig(chmodRequest: ChmodRequest? = null, mapAcls: MapAcl? = null, globalAux: String? = null,
                        dbpath: String? = null, connectionsLimit: Int? = null, bindip: List<String>? = null,
                        guest: Boolean? = null, guestUser: String? = null, listener: ApiListener)

}