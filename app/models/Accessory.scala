package models

import anorm._
import anorm.SqlParser._

import play.api.db._
import play.api.Play.current

case class Accessory(id: Int, productID: Int, accessoryID: Int)

object Accessory {
  val accessory = {
    get[Int]("id") ~
    get[Int]("productID") ~
    get[Int]("accessoryID") map {
      case id~productID~accessoryID => Accessory(id, productID, accessoryID)
    }
  }

  /*def create() {
    // TODO: We'll probably need to get FOREIGN KEY values productID and accessoryID
    DB.withConnection { implicit c =>
      SQL("insert into accessory(productID, accessoryID) values ({productID, accessoryID})").on(
        'productID -> productID,
        'accessoryID -> accessoryID
      ).executeInsert()
    }
  }*/
}
