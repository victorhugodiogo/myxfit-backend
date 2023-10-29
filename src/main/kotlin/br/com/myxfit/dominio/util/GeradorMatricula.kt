package br.com.myxfit.dominio.util

import com.aventrix.jnanoid.jnanoid.NanoIdUtils
import java.security.SecureRandom
import java.util.*

object GeradorMatricula {
    private const val PREFIX = "MYXFIT-"
    private const val DEFAULT_SIZE = 10
    private val RANDOM = SecureRandom()
    private val ID_ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray()

    /**
     * Generates a random string of size [size] that is made up from random characters in [alphabet].
     *
     * - Default prefix: MYXFIT-
     * - Default size: 8
     * - Default Alphabet: 0-9 and A-Z
     */
    fun generate(
        prefix: String = PREFIX,
        size: Int = DEFAULT_SIZE,
        random: Random = RANDOM,
        alphabet: CharArray = ID_ALPHABET
    ): String =
        "$prefix${NanoIdUtils.randomNanoId(random, alphabet, size)}"
            .also { println(it) }
}