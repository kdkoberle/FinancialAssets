delete from user_asset;
delete from user;
INSERT INTO FinancialAssets.user (user_id, email, first_name, last_name, password) VALUES (1, 'kdkoberle@madisoncollege.edu', 'Keith', 'Koberle', '123456');
INSERT INTO FinancialAssets.user (user_id, email, first_name, last_name, password) VALUES (2, 'jimmy@johns.com', 'Jimmy', 'John', '456789');
INSERT INTO FinancialAssets.user_asset (user_asset_id, buy_price, sell_price, buy_date, sell_date, asset_name, user_id, asset_id) VALUES (4, 13.51, 54.21, '2015-11-12', '2018-11-11', 'INTC', 1, 1);
INSERT INTO FinancialAssets.user_asset (user_asset_id, buy_price, sell_price, buy_date, sell_date, asset_name, user_id, asset_id) VALUES (5, 14.58, null, '2018-11-08', null, 'Silver', 1, 2);
INSERT INTO FinancialAssets.user_asset (user_asset_id, buy_price, sell_price, buy_date, sell_date, asset_name, user_id, asset_id) VALUES (6, 15.21, null, '2018-11-01', null, 'Silver', 1, 2);
INSERT INTO FinancialAssets.user_asset (user_asset_id, buy_price, sell_price, buy_date, sell_date, asset_name, user_id, asset_id) VALUES (7, 1225.21, null, '2018-10-10', null, 'Gold', 1, 3);