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

  def getAllByCustomer(id: Int): List[Order] = DB.withConnection { implicit c =>
    SQL("select * from orders o " +
      "where o.customerID = {id} ").on('id -> id).as(order *)
  }

  def getTotalPurchase(id: Int): List[Order] = DB.withConnection { implicit c =>
    SQL("select * from orders o " +
      "inner join ordersProducts op on op.ordersID = o.id " +
      "where o.customerID = {id} ").on('id -> id).as(order *)
  }

  def insert(id: Int) {
    DB.withConnection { implicit c =>
      SQL("insert into orders(createdAt, customerID) values ({currentDate}, {id})").on(
        'currentDate -> new Date(),
        'id -> id
      ).executeInsert()
    }
  }

  def getLatest(id: Int): List[Order] = DB.withConnection { implicit c =>
    SQL("select * from orders o " +
      "where o.customerID = {id} " +
      "order by o.id DESC Limit 1"
      ).on('id -> id).as(order *)
  }


  /*def create() {
    // TODO: We'll probably need to get a FOREIGN KEY value for customerID
    DB.withConnection { implicit c =>
      SQL("insert into orders(createdAt, customerID) values ({createdAt, customerID})").on(
        'createdAt -> createdAt,
        'customerID -> customerID
      ).executeInsert()
    }
  }*/
}
