import java.sql.Date
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.poifs.filesystem.POIFSFileSystem
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.DateUtil
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.Sheet
import com.simplescrum.model.*

/**
 *  To be executed in groovy console.Launch application with runConsole=true
 *  Requires: InitUsers and InitProductBacklog
 */
class BacklogParser {
  String filePath
  Product product;
  User ownerUser;
  def items = []

  def isNumeric = {object ->
    object != null && (object.toString() + "").isNumber()
  }

  def processRow = {Row row ->
    def estimationMap = ['A': EstimationType.HIGH, 'B': EstimationType.MEDIUM, 'C': EstimationType.LOW]
    def statusMap = ['TODO': ProductBacklogItemStatus.PlANIFIED, 'DONE': ProductBacklogItemStatus.ESTIMATED]
    ProductBacklogItem item = new ProductBacklogItem()
    item.product = product
    item.ownerUser = ownerUser
    item.type = ProductBacklogItemType.USER_STORY
    item.state = ProductBacklogItemStatus.PlANIFIED
    item.estimationType = EstimationType.LOW
    item.creationDate = new java.sql.Date(new Date().time)
    for (Cell cell: row) {
      def content = getCellContent(cell)
      def contentIsNumeric = isNumeric(content)
      def index = cell.getColumnIndex() + 1
      switch (index) {
        case 1:
          //Ignore lines with no assigned back log item id
          if (!contentIsNumeric) {
            return null
          }
          item.number = content
          break
        case 2:
          item.rank = content
          break
        case 3:
          if (content == null)
            return null
          item.label = content
          break;
        case 4:
          item.notes = content
          break
        case 5:
          item.howToTest = content
          break
        case 6:
          item.estimatedPoints = contentIsNumeric ? content : null
          break
        case 7:
          item.estimationType = content != null ? estimationMap.get(content) : EstimationType.LOW
          break
        case 8:
          item.estimationDate = content != null ? new java.sql.Date(content.time) : null
          break
        case 10:
          item.feature = content != null ? Feature.findByName(content) : null
          break
        case 11:
          item.plannedRelease = content != null ? Release.findByName(content) : null
          break
        case 12:
          item.budgetLine = content != null ? BudgetLine.findByName(content) : null
          break
        case 15:
          item.state = content != null ? statusMap.get(content) : ProductBacklogItemStatus.PlANIFIED
          break

      }
      //print("${content}:${index} - \t");
    }
    //println()
    item.number != null ? item : null
  }

  private def getCellContent(Cell cell) {
    def value = null
    switch (cell.getCellType()) {
      case Cell.CELL_TYPE_STRING:
        value = cell.getRichStringCellValue().getString();
        break;
      case Cell.CELL_TYPE_NUMERIC:
        if (DateUtil.isCellDateFormatted(cell)) {
          value = cell.getDateCellValue();
        } else {
          value = cell.getNumericCellValue();
        }
        break;
      case Cell.CELL_TYPE_BOOLEAN:
        value = cell.getBooleanCellValue();
        break;
      case Cell.CELL_TYPE_FORMULA:
        break;
    }
    value
  }

  def processFile = {
    product = com.simplescrum.model.Product.findByName('CRDS Web')
    ownerUser = com.simplescrum.model.User.findByLogin('smarmey')
    println("Parsing file..");
    // create a new file input stream with the input file specified
    // at the command line
    FileInputStream fin = new FileInputStream(filePath);
    // create a new org.apache.poi.poifs.filesystem.Filesystem
    POIFSFileSystem poifs = new POIFSFileSystem(fin);
    // get the Workbook (excel part) stream in a InputStream
    HSSFWorkbook wb = new HSSFWorkbook(poifs);
    Sheet sheet = wb.getSheetAt(3);
    for (Row row: sheet) {
      def item = processRow(row)
      if (item != null)
        items += item
    }

    // once all the events are processed close our file input stream
    fin.close();
    println("Found: ${items.size} backlog items")
    println("Deleting existing items..");
    ProductBacklogItem.list()*.delete()
    println("Saving to DB..");
    def success = []
    def failed = []
    items.each {itm ->
      Product.withTransaction {
        if (!itm.validate()) {
          // do something with user
          println "${itm.number}->${itm.errors.allErrors.join(',')}"
        }
        if (itm.save()) {
          success += itm.number
        } else {
          failed += itm.number

        }
      }
    }
    println("Sucess(${success.size}):[${success.join(',')}]")
    println("Failure(${failed.size}):[${failed.join(',')}]")
    println("done.");
  }

}

final BacklogParser parser = new BacklogParser(filePath: '/home/itux/Development/Artificats/CRDSWeb_Product_Backlog_NG.xls')
parser.processFile()

//parser.items.join("\n")