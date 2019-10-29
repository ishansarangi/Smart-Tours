const csv = require('fast-csv');

var result_arr = [];
var id = 1;

var temp = [];
	temp.push('Beacon_Id');
	temp.push('AccessionNumber');

result_arr.push(temp);

csv.parseFile('./Artwork_result.csv', {headers: true})
.on('data', row => {
  var temp = [];
	  temp.push(id++);
	  temp.push(row.AccessionNumber);
	  
  result_arr.push(temp);
})
.on("end", () => {
  csv.writeToPath('./Beacon_result.csv', result_arr);
});