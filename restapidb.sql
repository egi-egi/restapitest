drop database if exists restapidb;
create database restapidb;
use restapidb;
create table currencies(amount double, cnbMid double, country varchar(100), currBuy double, currSell double, currMid double, move double, name varchar(50), shortName varchar(10), valBuy double, validFrom datetime, valMid double, valSell double, version double);

