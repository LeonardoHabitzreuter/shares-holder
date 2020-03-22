package TypeDefs

import modules.project._
import modules.user._
import sangria.macros.derive._

class Query {
  @GraphQLField
  def project() = {
    ProjectsRepo.projects(0)
  }
}

class Mutation {
  @GraphQLField
  def createUser(email: String, password: String) = {
    val user = User(email, password)

    "1"
  }
}
