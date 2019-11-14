case class Project(
    id: String,
    name: String,
    description: String,
    image: String
)

class ProjectsRepo {
  import ProjectsRepo._

  def getProject(id: String) = projects.find(c ⇒ c.id == id)

  def getProject(offset: Int) = projects.drop(offset).headOption
}

object ProjectsRepo {
  val projects = List(
    Project(
      id = "1",
      image = "https://picsum.photos/100/100",
      name = "Test",
      description = "test"
    )
  )
}
