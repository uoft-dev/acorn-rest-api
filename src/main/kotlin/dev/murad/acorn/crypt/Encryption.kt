package dev.murad.acorn.crypt

import java.security.KeyPair
import java.security.KeyPairGenerator
import java.security.PrivateKey
import java.security.PublicKey
import javax.crypto.Cipher

class Encryption {

    private var keygen: KeyPairGenerator = KeyPairGenerator.getInstance("RSA")
    private var pair: KeyPair = keygen.generateKeyPair()

    var privateKey: PrivateKey = pair.private
        private set

    var publicKey: PublicKey = pair.public
        private set

    private var cipher: Cipher = Cipher.getInstance("RSA")

    fun decrypt(payload: ByteArray): ByteArray {
        this.cipher.init(Cipher.DECRYPT_MODE, privateKey)
        return this.cipher.doFinal(payload)
    }

    fun encrypt(payload: ByteArray): ByteArray {
        this.cipher.init(Cipher.ENCRYPT_MODE, publicKey)
        return this.cipher.doFinal(payload);
    }

}
