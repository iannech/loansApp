var express = require('express');
var request = require('request');
var http = require('http');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
    /*Expected data format
    {
        loan_amount: 3000,
        credit_score: "Good",
        history:[{
            date: "30 Jun",
            loan_amount: 2000
        }, {
            date: "30 Jun",
            loan_amount: 2000
        }]
    }*/
    res.render('index',
    {   title: 'Loan App',
        //data: JSON.parse(response.body),
        data: {
            loan_amount: 3000,
            credit_score: "Good",
            history:[{
                date: "30 Jun",
                loan_amount: 2000
            }, {
                date: "30 Jun",
                loan_amount: 2000
            }]
        }
    }
   );
    let post_options = {
        uri: "",/*place microservice url here */
        method: "GET",
        rejectUnauthorized: false,
    };
    
    // request(post_options, function (error, response, body) {
    //     if(response.statusCode == 200){
    //         res.render('index',
    //             {   title: 'Loan App',
    //                 data: JSON.parse(response.body),
    //                 data: {
    //                     loan_amount: 3000,
    //                     credit_score: "Good",
    //                     history:[{
    //                         date: "30 Jun",
    //                         loan_amount: 2000
    //                     }, {
    //                         date: "30 Jun",
    //                         loan_amount: 2000
    //                     }]
    //                 }
    //             }
    //         );
    //     }
    // });
});

module.exports = router;
