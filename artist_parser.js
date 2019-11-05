const csv = require('fast-csv');

var result_arr = [];

var temp = [];
    temp.push("ConstituentID");
    temp.push("ArtistName");
    temp.push("ArtistBio");
    temp.push("Nationality");
    temp.push("Gender");
    temp.push("BeginDate");
    temp.push("EndDate");
    temp.push("Wiki_QID");
    temp.push("ULAN");

    result_arr.push(temp);

csv.parseFile('./Artists.csv', {headers: true})
.on('data', data => {

  if(data.ConstituentID != '' && data.DisplayName != '' && data.ArtistBio != '' && data.Nationality != '' &&
    data.Gender != '' && data.BeginDate != 0 && data.EndDate != 0 && data.Wiki_QID != '' && data.ULAN != ''){
    var temp = [];
    temp.push(data.ConstituentID);
    temp.push(data.DisplayName);
    temp.push(data.ArtistBio);
    temp.push(data.Nationality);
    temp.push(data.Gender);
    temp.push(data.BeginDate);
    temp.push(data.EndDate);
    temp.push(data.Wiki_QID);
    temp.push(data.ULAN);

    result_arr.push(temp);
  }

})
.on("end", () => {
  csv.writeToPath('./result_set/Artist_result.csv', result_arr);
});


