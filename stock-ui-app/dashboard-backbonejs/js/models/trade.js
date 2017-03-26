// Filename: models/stock
define([
  'underscore',
  'backbone'
], function(_, Backbone){
  var Trade = Backbone.Model.extend({
    defaults: {
      name: "Harry Potter"
    }
  });
  // Return the model for the module
  return Trade;
});