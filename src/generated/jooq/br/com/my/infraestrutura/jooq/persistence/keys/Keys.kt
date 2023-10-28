/*
 * This file is generated by jOOQ.
 */
package br.com.my.infraestrutura.jooq.persistence.keys


import br.com.my.infraestrutura.jooq.persistence.tables.Partner

import org.jooq.Record
import org.jooq.UniqueKey
import org.jooq.impl.DSL
import org.jooq.impl.Internal



// -------------------------------------------------------------------------
// UNIQUE and PRIMARY KEY definitions
// -------------------------------------------------------------------------

val KEY_PARTNER_PRIMARY: UniqueKey<Record> = Internal.createUniqueKey(Partner.PARTNER, DSL.name("KEY_partner_PRIMARY"), arrayOf(Partner.PARTNER.ID), true)
