create table lwsUser(
lwsuserid int primary key ,
lwsusername varchar2(20) not null,
lwspwd varchar2(20)not null,
mail varchar2(50) not null
);
drop table lwsUser;
create sequence lwsUser_lwsuserid start with 10001 increment by 1;
