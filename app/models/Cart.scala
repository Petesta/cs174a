package models

import anorm._
import anorm.SqlParser._

import java.util.{Date}

import play.api.db._
import play.api.Play.current

case class Cart(id: Int, createdAt: Date, customerID: Int)

object Cart {
  val cart = {
    get[Int]("id") ~
    get[Date]("createdAt") ~
    get[Int]("customerID") map {
      case id~createdAt~customerID => Cart(id, createdAt, customerID)
    }
  }

  def create() {
    // TODO: We'll probably need to get a FOREIGN KEY value for customerID and create a Date
    DB.withConnection { implicit c =>
      SQL("insert into carts(createdAt, customerID) values ({createdAt, customerID})").on(
        'createdAt -> createdAt,
        'customerID -> customerID
      ).executeInsert()
    }
  }
}
