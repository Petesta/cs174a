package models

import anorm._
import anorm.SqlParser._

import java.util.{Date}

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

  def getAll(): List[Customer] = DB.withConnection { implicit c =>
    SQL("select * from customers").as(customer *)
  }

  def updateStatus(id: Int, status: String) {
    DB.withConnection { implicit c =>
      SQL("update customers set status={status} where id = {id}").on(
        'status -> status,
        'id -> id
      ).executeUpdate()
    }
  }


  def create(depotID: String, firstName: String, lastName: String, email: String, password: String, street: String, status: String) {
    DB.withConnection { implicit c =>
      SQL("insert into customers(depotID, firstName, lastName, email, password, street, status) values ({depotID}, {firstName}, {lastName}, {email}, {password}, {street}, {status})").on(
        'depotID -> depotID,
        'firstName -> firstName,
        'lastName -> lastName,
        'email -> email,
        'password -> password,
        'street -> street,
        'status -> status).executeInsert()

      val firstRow = SQL("select id from customers order by id desc limit 1").apply().head
      val customerID = firstRow[Int]("id")
      println(customerID)

      SQL("insert into carts(createdAt, customerID) values ({createdAt}, {customerID})").on(
        'createdAt -> new Date(),
        'customerID -> customerID
      ).executeInsert()
    }
  }

  def findCustomerID(): String = DB.withConnection { implicit c =>
    val row = SQL("select id from customers order by id desc limit 1").apply().head
    row[Int]("id").toString
  }
}
