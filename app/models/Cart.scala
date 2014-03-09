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

  def newCart(id: Int) {
    DB.withConnection { implicit c =>
      SQL("insert into carts(createdAt, customerID) values ({currentDate}, {id})").on(
        'currentDate -> new Date(),
        'id -> id
      ).executeInsert()
    }
  }
}
