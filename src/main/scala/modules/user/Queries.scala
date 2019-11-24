package modules.user

class UsersRepo {
  import UsersRepo._

  def getUser(id: String) = users.find(c ⇒ c.id == id)

  def getUser(offset: Int) = users.drop(offset).headOption
}

object UsersRepo {
  val users = List(
    User(
      id = "1",
      name = "Test"
    )
  )
}
