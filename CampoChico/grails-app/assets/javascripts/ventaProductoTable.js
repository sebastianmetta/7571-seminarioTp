/**
 * 
 */

document.addEventListener("DOMContentLoaded", function() {

  function getCarData() {
    return [
      ["Nissan", 2012, "black", "black"],
      ["Nissan", 2013, "blue", "blue"],
      ["Chrysler", 2014, "yellow", "black"],
      ["Volvo", 2015, "white", "gray"]
    ];
  }
  
  var
    container = document.getElementById('example1'),
    hot;
  
  hot = new Handsontable(container, {
    data: getCarData(),
    colHeaders: ['Car', 'Year', 'Chassis color', 'Bumper color'],
    columns: [
      {},
      {type: 'numeric'},
      {
        type: 'dropdown',
        source: ['yellow', 'red', 'orange', 'green', 'blue', 'gray', 'black', 'white']
      },
      {
        type: 'dropdown',
        source: ['yellow', 'red', 'orange', 'green', 'blue', 'gray', 'black', 'white']
      }
    ]
  });
  
  function bindDumpButton() {
      if (typeof Handsontable === "undefined") {
        return;
      }
  
      Handsontable.Dom.addEvent(document.body, 'click', function (e) {
  
        var element = e.target || e.srcElement;
  
        if (element.nodeName == "BUTTON" && element.name == 'dump') {
          var name = element.getAttribute('data-dump');
          var instance = element.getAttribute('data-instance');
          var hot = window[instance];
          console.log('data of ' + name, hot.getData());
        }
      });
    }
  bindDumpButton();

});