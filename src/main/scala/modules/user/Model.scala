package modules.user

import slick.jdbc.PostgresProfile.api._
import slick.lifted.{ProvenShape, ForeignKeyQuery}

case class User(email: String, password: String, id: Option[Int] = None)

class Users(tag: Tag) extends Table[User](tag, "users") {
  def id = column[Int]("ID", O.PrimaryKey, O.AutoInc)
  def email = column[String]("email")
  def password = column[String]("password")
  def * = (email, password, id.?) <> (User.tupled, User.unapply)
}

