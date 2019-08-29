CREATE TABLE `CompanyAdministrator` (
`companyAdmID`  varchar(36) NOT NULL ,
`companyAdmName`  varchar(36) NULL ,
`employeeID`  varchar(36) NOT NULL ,
PRIMARY KEY (`companyAdmID`)
)

CREATE TABLE `Company` (
`companyID`  varchar(36) NOT NULL ,
`companyName`  varchar(36) NULL ,
`sysAdmID`  varchar(36) NULL ,
`companyAdmID`  varchar(36) NULL ,
PRIMARY KEY (`companyID`)
)

CREATE TABLE `SystemAdministrator` (
`SysAdmID`  varchar(36) NOT NULL ,
`username`  varchar(36) NULL ,
`password`  varchar(36) NULL ,
PRIMARY KEY (`SysAdmID`)
)

CREATE TABLE `Employee` (
`employeeID`  varchar(36) NOT NULL ,
`companyID`  varchar(36) NOT NULL ,
`employeeName`  varchar(36) NULL ,
`employeeAge`  varchar(36) NULL ,
`employeeGender`  varchar(36) NULL ,
PRIMARY KEY (`employeeID`)
)