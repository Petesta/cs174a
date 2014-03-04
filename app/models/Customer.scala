package models

import anorm._
import anorm.SqlParser._

import play.api.db._
import play.api.Play.current

case class Customer(id: Int, firstName: String, lastName: String, email: String, password: String, street: String, zip: String, city: String, status: String)

object Customer {
  val customer = {
    get[Int]("id") ~
    get[String]("firstName") ~
    get[String]("lastName") ~
    get[String]("email") ~
    get[String]("password") ~
    get[String]("street") ~
    get[String]("zip") ~
    get[String]("city") ~
    get[String]("status") map {
      case id~firstName~lastName~email~password~street~zip~city~status => Customer(id, firstName, lastName, email, password, street, zip, city, status)
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
