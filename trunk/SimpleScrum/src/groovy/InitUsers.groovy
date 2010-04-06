import com.simplescrum.model.AccessRole
import com.simplescrum.model.Team
import com.simplescrum.model.User

/**
 *  To be executed in groovy console.Launch application with runConsole=true
 *  Requires: none
 */

User.withTransaction {
//Create default access Role
  def defaultRole = 'ROLE_USER'
  def defaultAccessRole = new AccessRole(authority: defaultRole, description: 'Default Access Role').save()
  def encryptedPassword = 'a94a8fe5ccb19ba61c4c0873d391e987982fbbd3' // Real password is 'test'
//Create users
  def productOwner = new User(login: 'smarmey', password: encryptedPassword, userRealName: 'Sebastien Marmey', email: 'test@mail.com')
  defaultAccessRole.addToPeople(productOwner)
  def ielali = new User(login: 'ielali', password: encryptedPassword, userRealName: 'Imad Elali', email: 'test@mail.com')
  defaultAccessRole.addToPeople(ielali)
  def jhallot = new User(login: 'jhallot', password: encryptedPassword, userRealName: 'Jean-Philippe Hallot', email: 'test@mail.com')
  defaultAccessRole.addToPeople(jhallot)
  def nkhan = new User(login: 'nkahn', password: encryptedPassword, userRealName: 'Nazir Khan', email: 'test@mail.com')
  defaultAccessRole.addToPeople(nkhan)

  defaultAccessRole.save()

//Create Teams
  def teamOne = new Team(label: 'Team 1', descritpion: 'Team One').save()
  def teamTwo = new Team(label: 'Team 2', descritpion: 'Team Two').save()
  def teamThree = new Team(label: 'Team 3', descritpion: 'Team Three').save()
  def teamFour = new Team(label: 'Team 4', descritpion: 'Team Four').save()

  //AuditLog.list()
}



