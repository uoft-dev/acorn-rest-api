package dev.murad.acorn.crypt

import java.security.KeyPair
import java.security.KeyPairGenerator
import java.security.PrivateKey
import java.security.PublicKey
import java.util.*
import javax.crypto.Cipher

class Encryption {

    private var keygen: KeyPairGenerator = KeyPairGenerator.getInstance("RSA")
    private var pair: KeyPair = keygen.generateKeyPair()

    private var privateKey: PrivateKey = pair.private
    private var publicKey: PublicKey = pair.public

    var pubkey: String = Base64.getEncoder().encodeToString(publicKey.encoded)
        private set

    private var cipher: Cipher = Cipher.getInstance("RSA")

    fun decrypt(payload: String): String {
        this.cipher.init(Cipher.DECRYPT_MODE, privateKey)

        val p: ByteArray = Base64.getDecoder().decode(payload)
        return String(this.cipher.doFinal(p))
    }

    fun encrypt(payload: String): String {
        this.cipher.init(Cipher.ENCRYPT_MODE, publicKey)

        val p: ByteArray = Base64.getDecoder().decode(payload);
        return String(this.cipher.doFinal(p))
    }

}
