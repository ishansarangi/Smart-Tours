const csv = require('fast-csv');

var result_arr = [];

var temp = [];
    temp.push("Title");
    temp.push("Artists");
    temp.push("ConstituentID");
    temp.push("Date");
    temp.push("Medium");
    temp.push("Dimensions");
    temp.push("CreditLine");
    temp.push("AccessionNumber");
    temp.push("Classification");
    temp.push("Department");
    temp.push("DateAcquired");
    temp.push("ObjectID");
    temp.push("URL");
    temp.push("ThumbnailURL");
    temp.push("Height");
    temp.push("Width");

result_arr.push(temp);

csv.parseFile('./Artworks.csv', {headers: true})
.on('data', data => {

  if(data.Title != '' && data.Artists != '' && data.ConstituentID != '' &&
    data.Date != '' && data.Medium != 0 && data.Dimensions != 0 && data.CreditLine != '' && data.AccessionNumber != '' &&
    data.Classification != '' && data.Department != '' && data.DateAcquired != '' && data.ObjectID != '' && data.URL != '' &&
    data.ThumbnailURL != '' && data.Height != '' && data.Width != ''){
    var temp = [];
        temp.push(data.Title);
        temp.push(data.Artist);
        temp.push(data.ConstituentID);
        temp.push(data.Date);
        temp.push(data.Medium);
        temp.push(data.Dimensions);
        temp.push(data.CreditLine);
        temp.push(data.AccessionNumber);
        temp.push(data.Classification);
        temp.push(data.Department);
        temp.push(data.DateAcquired);
        temp.push(data.ObjectID);
        temp.push(data.URL);
        temp.push(data.ThumbnailURL);
        temp.push(data.Height);
        temp.push(data.Width);

    result_arr.push(temp);
  }

})
.on("end", () => {
  csv.writeToPath('./Artwork_result.csv', result_arr);
});


