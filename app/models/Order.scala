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
