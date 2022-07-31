-- # Coupons For User with id=1
insert into COUPON (ID, VALUE, AVAILABLEREDEEMS) values (COUPON_SEQ.nextval, 10, 8);
insert into COUPON (ID, VALUE, AVAILABLEREDEEMS) values (COUPON_SEQ.nextval, 7, 6);
insert into COUPON (ID, VALUE, AVAILABLEREDEEMS) values (COUPON_SEQ.nextval, 8, 7);
insert into COUPON (ID, VALUE, AVAILABLEREDEEMS) values (COUPON_SEQ.nextval, 5, 4);

-- # Coupons For User with id=2
insert into COUPON (ID, VALUE, AVAILABLEREDEEMS) values (COUPON_SEQ.nextval, 2, 4);
insert into COUPON (ID, VALUE, AVAILABLEREDEEMS) values (COUPON_SEQ.nextval, 4, 6);
insert into COUPON (ID, VALUE, AVAILABLEREDEEMS) values (COUPON_SEQ.nextval, 6, 8);
insert into COUPON (ID, VALUE, AVAILABLEREDEEMS) values (COUPON_SEQ.nextval, 8, 10);

-- # Users
insert into USER (ID, FIRSTNAME, LASTNAME) values (USER_SEQ.nextval, 'Mike', 'Lamprakis');
insert into USER (ID, FIRSTNAME, LASTNAME) values (USER_SEQ.nextval, 'James', 'Hetfield');

-- # Populating The listOfCoupons For User with id=1
insert into USER_LISTOFCOUPONS (USER_ID, LISTOFCOUPONS_ID) values (1, 1);
insert into USER_LISTOFCOUPONS (USER_ID, LISTOFCOUPONS_ID) values (1, 2);
insert into USER_LISTOFCOUPONS (USER_ID, LISTOFCOUPONS_ID) values (1, 3);
insert into USER_LISTOFCOUPONS (USER_ID, LISTOFCOUPONS_ID) values (1, 4);

-- # Populating The listOfCoupons For User with id=2
insert into USER_LISTOFCOUPONS (USER_ID, LISTOFCOUPONS_ID) values (2, 5);
insert into USER_LISTOFCOUPONS (USER_ID, LISTOFCOUPONS_ID) values (2, 6);
insert into USER_LISTOFCOUPONS (USER_ID, LISTOFCOUPONS_ID) values (2, 7);
insert into USER_LISTOFCOUPONS (USER_ID, LISTOFCOUPONS_ID) values (2, 8);
