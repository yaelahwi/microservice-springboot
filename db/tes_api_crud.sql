/*
 Navicat Premium Data Transfer

 Source Server         : localhost_5432
 Source Server Type    : PostgreSQL
 Source Server Version : 120004
 Source Host           : localhost:5432
 Source Catalog        : crud_api
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 120004
 File Encoding         : 65001

 Date: 10/10/2020 20:08:15
*/


-- ----------------------------
-- Sequence structure for employee_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."employee_id_seq";
CREATE SEQUENCE "public"."employee_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 987654321
START 1
CACHE 1;
ALTER SEQUENCE "public"."employee_id_seq" OWNER TO "postgres";

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS "public"."employee";
CREATE TABLE "public"."employee" (
  "employee_id" int8 NOT NULL,
  "employee_name" varchar(30) COLLATE "pg_catalog"."default",
  "employee_address" varchar(50) COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "public"."employee" OWNER TO "postgres";

-- ----------------------------
-- Records of employee
-- ----------------------------
BEGIN;
INSERT INTO "public"."employee" VALUES (1, 'Alwi', 'Sunda');
COMMIT;

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
SELECT setval('"public"."employee_id_seq"', 3, true);

-- ----------------------------
-- Primary Key structure for table employee
-- ----------------------------
ALTER TABLE "public"."employee" ADD CONSTRAINT "employee_pkey" PRIMARY KEY ("employee_id");
