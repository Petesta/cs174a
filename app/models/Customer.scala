package models

import anorm._
import anorm.SqlParser._

import play.api.db._
import play.api.Play.current

case class Customer(id: Int, depotID: String, firstName: String, lastName: String, email: String, password: String, street: String, status: String)

object Customer {
  val customer = {
    get[Int]("id") ~
    get[String]("depotID") ~
    get[String]("firstName") ~
    get[String]("lastName") ~
    get[String]("email") ~
    get[String]("password") ~
    get[String]("street") ~
    get[String]("status") map {
      case id~depotID~firstName~lastName~email~password~street~status => Customer(id, depotID, firstName, lastName, email, password, street, status)
    }
  }

  /*def create(firstName: String, lastName: String, email: String, password: String, street: String, zip: String, city: String) {
    DB.withConnection { implicit c =>
      SQL("insert into customers(firstName, lastName, email, password, street, zip, city) values ({firstName, lastName, email, password, street, zip, city})").on(
        'firstName -> firstName,
        'lastName -> lastName,
        'email -> email,
        'password -> password,
        'street -> street,
        'zip -> zip,
        'city -> city).executeInsert()
    }
  }*/
}
