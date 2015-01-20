# This is the Jenkins Workflow script, to be copied in Workflow Script window in Jenkins Wrkflow Job

node {
	git url: 'https://github.com/kermek/GroovyExcelReaderInIDEA.git'

	textFile = readFile('.\\TA approach.csv') // Reading text file as a string from the node's workspace

	Reader reader = new StringReader(textFile) // Converting String to Reader

	List<String[]> rows = new CSVReader(reader, CSVParser.DEFAULT_SEPARATOR, CSVParser.DEFAULT_ESCAPE_CHARACTER, CSVParser.DEFAULT_QUOTE_CHARACTER, 1).readAll()

	println 'Total line: '+ rows.size()

	for (int i = 0; i < rows.size(); i++) {
	  for (int j = 0; j < rows.get(i).size(); j++) {
	    println 'Line #' + (i + 1) + ', Cell #' + (j+1) + ' = ' + rows.get(i)[j]
	  }
	}
}

import com.opencsv.CSVReader
import com.opencsv.CSVParser // Not used
import com.opencsv.CSVWriter // Not used