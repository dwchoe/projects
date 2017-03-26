// Filename: views/projects/list
define([
    'jquery',
    'underscore',
    'backbone',
    '../../models/stock'
], function($, _, Backbone, Stock){
    var stock = new Stock();
    stock.set({symbol: 'AAA'});
    console.log('stock: ' + stock.get('symbol'));

    //var stocks = new StockCollection();

    var PortfolioPageView = Backbone.View.extend({
        model: stock,
        initialize: function() {
            this.model.bind('change',this.render, this);
            console.log('about - initialize');
        },
        el: $(".main"),
        //template: _.template($("#about").html()),
        render: function () {
            console.log('about page render called: ' + stock.get('symbol'));
            console.log('about page render this.model: ' + this.model.get('symbol'));
            var that = this;

            stock.fetch({
                success: function (model, response) {
                    symbol = model.get('symbol');
                    console.log('successfully fetch stocks ' + symbol);
                },
                error: function () {
                    console.log('error')
                }
            });

            $.get('templates/portfolio.html', function (data) {
                template = _.template(data, {});//Option to pass any dynamic values to template
                that.$el.html(template({msg: stock}));//adding the template content to the main template.
            }, 'html');
        }
    });

    // Returning instantiated views can be quite useful for having "state"
    return PortfolioPageView;
});