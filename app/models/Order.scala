package models

import anorm._
import anorm.SqlParser._

import java.util.{Date}

import play.api.db._
import play.api.Play.current

case class Order(id: Int, createdAt: Date, customerID: Int)

object Order {
  val order = {
    get[Int]("id") ~
    get[Date]("createdAt") ~
    get[Int]("customerID") map {
      case id~createdAt~customerID => Order(id, createdAt, customerID)
    }
  }

  def findPreviousOrder(customerID: Int): List[Order] = DB.withConnection { implicit c =>
    SQL("select * from orders where customerID = {customerID}").on(
      'customerID -> customerID
    ).as(order *)
  }

  /*
  def createOrder(customerID: Int) {
    DB.withConnection { implicit c =>
      SQL("insert into orders(createdAt, customerID) values ({createdAt}, {customerID})").on(
        'createdAt -> new Date(),
        'customerID -> customerID
      ).executeInsert()

      SQL("delete from cartProducts where cartID = {cartID}").on(
        'cartID -> customerID
      ).executeUpdate()
    }
  }
  */
}
