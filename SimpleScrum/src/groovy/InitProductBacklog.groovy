import java.sql.Date
import com.simplescrum.model.*

/**
 *  To be executed in groovy console.Launch application with runConsole=true
 *  Requires: InitUsers
 */

def getSqlDate = {GregorianCalendar cal ->
  if (cal != null) {
    new Date(cal.time.time)
  }
}

Product.withTransaction {
//Create a Product assign an ownner
  def productOwner = User.findByLogin('smarmey')
  def crdsWeb = new Product(name: 'CRDS Web', description: 'CRDS Web migration', startDate: getSqlDate(new GregorianCalendar(2007, Calendar.DECEMBER, 1))).save()
  def ownerRole = new Role(name: RoleType.PRODUCT_OWNER, description: 'Product owner', product: crdsWeb)
  productOwner.addToRoles(ownerRole)
  productOwner.save()
  Product.list()
}
BudgetLine.withTransaction {
//Add BugetLines
  def holidaysBudgetLine = new BudgetLine(name: 'Holidays', description: 'Holidays Read/Write Budget line').save()
}
Release.withTransaction {
  def crdsWeb = Product.findByName('CRDS Web')
//Add releases
  def septemberRelease = new Release(name: 'Sep', goal: 'To release by spetemeber 2009', state: ReleaseStatus.OPEN,
          startDate: getSqlDate(new GregorianCalendar(2008, Calendar.SEPTEMBER, 01)), publishDate: getSqlDate(new GregorianCalendar(2009, Calendar.NOVEMBER, 9)), type: ReleaseType.NORMAL, releaseVelocity: 0, estimatedSprintDuration: 2, defaultEstimatedVelocity: 0);
  septemberRelease.save()
  def decRelease = new Release(name: 'Dec', goal: 'To release by spetemeber 2009', state: ReleaseStatus.OPEN,
          startDate: getSqlDate(new GregorianCalendar(2009, Calendar.NOVEMBER, 10)), publishDate: getSqlDate(new GregorianCalendar(2009, Calendar.DECEMBER, 9)), type: ReleaseType.NORMAL, releaseVelocity: 0, estimatedSprintDuration: 2, defaultEstimatedVelocity: 0);
  decRelease.save()

  def feature;
  feature = new Feature(name: 'security', description: 'Security Feature', product: crdsWeb).save();
  feature = new Feature(name: 'Bug fixes 1', description: '', product: crdsWeb).save();
  feature = new Feature(name: 'Bug fixes 2', description: '', product: crdsWeb).save();
  feature = new Feature(name: 'RW-NonLegal', description: 'Non Legal Module Read/Wrire', product: crdsWeb).save();
  feature = new Feature(name: 'RW-Joker', description: 'Joker Module Read/Writer', product: crdsWeb).save();
  feature = new Feature(name: 'RW-BIC', description: 'BIC Moduke Read/Write', product: crdsWeb).save();
  feature = new Feature(name: 'Improvement', description: 'Improvement to existing Client/Server functionality', product: crdsWeb).save();
  feature = new Feature(name: 'RW-Pending', description: 'Pending Legal Module Read/Write', product: crdsWeb).save();
  feature = new Feature(name: 'RW-Legal', description: 'Legal Module Read/Write', product: crdsWeb).save();
  feature = new Feature(name: 'RW-Private', description: 'Private Module Read/Write', product: crdsWeb).save();
  feature = new Feature(name: 'RW-Event', description: 'Event Module Read/Write', product: crdsWeb).save();
  feature = new Feature(name: 'Holidays', description: 'Holidays Module Read/Write', product: crdsWeb).save();
  feature = new Feature(name: 'Holidays Enhancement', description: 'Holidays Module enhancements', product: crdsWeb).save();
  feature = new Feature(name: 'RW-MAOS', description: 'MOAS Module Read/Write', product: crdsWeb).save();
  feature = new Feature(name: 'RO-RMPMGroup', description: 'RMPMGroup Module Read/Write', product: crdsWeb).save();
  feature = new Feature(name: 'RO', description: 'Read Only', product: crdsWeb).save();
  feature = new Feature(name: 'Write', description: 'Write', product: crdsWeb).save();
  feature = new Feature(name: 'RW-Restitution', description: 'Restitution Module Read/Write', product: crdsWeb).save();
  feature = new Feature(name: 'RW-Classification', description: 'Classification Module Read/Write', product: crdsWeb).save();
  feature = new Feature(name: 'RW-Jurisdiction', description: 'Jurisdiction Module Read/Write', product: crdsWeb).save();
  feature = new Feature(name: 'RW-Jurisdiction-Management', description: 'User jurisdiction management', product: crdsWeb).save();
  feature = new Feature(name: 'intranet', description: 'Intranet Migration', product: crdsWeb).save();
  feature = new Feature(name: 'MKP', description: '', product: crdsWeb).save();
  feature = new Feature(name: 'RW-CDQ/Cleaning review Date', description: 'CDQ/Cleaning review Date Module Read/Write', product: crdsWeb).save();
  feature = new Feature(name: 'RW-Counterpart Change Code', description: 'Counterpart Change Code Module Read/Write', product: crdsWeb).save();

  Feature.list()
}