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

package de.markusressel.freenasrestapiclient.api.v2.certificate

import com.github.kittinunf.result.Result
import com.google.gson.JsonElement
import de.markusressel.freenasrestapiclient.api.v2.ApiEnum
import de.markusressel.freenasrestapiclient.api.v2.QueryFilter
import de.markusressel.freenasrestapiclient.api.v2.QueryOptions

interface CertificateAuthorityApi {

    enum class CreateType : ApiEnum {
        CA_CREATE_INTERNAL,
        CA_CREATE_IMPORTED,
        CA_CREATE_INTERMEDIATE
    }

    /**
     *
     */
    suspend fun certificateAuthoritySignCsr(caId: Int, csrCertId: Int, name: String): Result<JsonElement, Exception>

    /**
     * Creates a new certificate authority
     */
    suspend fun createCertificateAuthority(
            signedby: Int,
            key_length: Int,
            type: Int,
            lifetime: Int,
            serial: Int,
            certificate: String,
            city: String,
            common: String,
            country: String,
            CSR: String,
            email: String,
            name: String,
            organization: String,
            passphrase: String,
            privatekey: String,
            state: String,
            create_type: CreateType,
            digest_algorithm: CertificateApi.DigestAlgorithm,
            san: List<String>): Result<JsonElement, Exception>

    /**
     * Deletes a certificate authority
     *
     * @param id id of CA
     */
    suspend fun deleteCertificateAuthority(id: Int): Result<JsonElement, Exception>

    /**
     * Queries a list of certificate authorities
     */
    suspend fun getCertificateAuthorities(queryFilters: List<QueryFilter> = emptyList(),
                                          queryOptions: QueryOptions = QueryOptions()): Result<JsonElement, Exception>

    /**
     * Updates a certificate authority
     *
     * @param id id of CA
     */
    suspend fun updateCertificateAuthority(id: Int): Result<JsonElement, Exception>

}