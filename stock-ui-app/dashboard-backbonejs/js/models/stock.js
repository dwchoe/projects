define([
  'underscore',
  'backbone'
], function(_, Backbone){
  var Stock = Backbone.Model.extend({
  	url: "http://stock-services.herokuapp.com/stocks",
    defaults: {
      message: "My Message from Model",
      symbol: ""
    }
  });
  // Return the model for the module
  return Stock;
});