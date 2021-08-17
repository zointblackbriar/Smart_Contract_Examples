

var loggingApp = require('log4js'); 
var logger = log4js.getLogger('TradeApp'); 
var express = require('express'); 
var bodyparser = require('body-parser'); 
var http = require('http'); 
var util = require('util');
var app = express(); 

var expressJWT = require('express-jwt'); 
var jwt = require('jsonwebtoken'); 
var bearerToken = require('express-bearer-token'); 
var cors = require('cors'); 
var path = require('path'); 


