/** Sql Generate **/
 DROP TABLE t_balance;

CREATE TABLE  t_balance
(
       symbol            VARCHAR(200) NOT NULL,
       NAME              VARCHAR(200),
       CURDATE           VARCHAR(20) NOT NULL,
       cash_shortinvest  NUMERIC(10,2),
       receivables       NUMERIC(10,2),
       stock             NUMERIC(10,2),
       assets_current    NUMERIC(10,2),
       assets_total      NUMERIC(10,2),
       debts_current     NUMERIC(10,2),
       debts_total       NUMERIC(10,2),
       shareholders      NUMERIC(10,2),
       stocks_numbers    NUMERIC(10,2),
       lastUpdateTime    DATETIME,
       reporttype        VARCHAR(2) NOT NULL,
       PRIMARY KEY(symbol,CURDATE,reporttype)
);
 DROP TABLE t_baseinfos;
CREATE TABLE  t_baseinfos
(
       symbol            VARCHAR(20) NOT NULL,
       NAME              VARCHAR(300),
       cname             VARCHAR(300),
       category          VARCHAR(300),
       market            VARCHAR(300),
       category_id       INTEGER,
       price             NUMERIC(10,4),
       diff              NUMERIC(10,4),
       chg               NUMERIC(10,4),
       preclose          NUMERIC(10,4),
       OPEN              NUMERIC(10,4),
       high              NUMERIC(10,4),
       low               NUMERIC(10,4),
       amplitude         VARCHAR(20),
       volume            NUMERIC(20,1),
       mktcap            NUMERIC(20,1),
       pe                NUMERIC(20,12),
       lastUpdateTime    DATETIME,
       PRIMARY KEY((symbol)
);
 DROP TABLE t_incomes;
CREATE TABLE  t_incomes
(
       symbol            VARCHAR(200) NOT NULL,
       NAME              VARCHAR(200),
       CURDATE           VARCHAR(200) NOT NULL,
       income            NUMERIC(10,2),
       gross_profit      NUMERIC(10,2),
       operating_costs   NUMERIC(10,2),
       operating_profits NUMERIC(10,2),
       pretax_profits    NUMERIC(10,2),
       net_profit        NUMERIC(10,2),
       net_profit_exclude NUMERIC(10,2),
       per_share         NUMERIC(10,2),
       unit              VARCHAR(10),
       lastUpdateTime    DATETIME,
       reporttype        VARCHAR(2) NOT NULL,
       PRIMARY KEY((symbol,CURDATE,reporttype)
);
 DROP TABLE t_cashflows;
CREATE TABLE  t_cashflows
(
       symbol            VARCHAR(200) NOT NULL,
       NAME              VARCHAR(200),
       CURDATE           VARCHAR(200) NOT NULL,
       operation_case    NUMERIC(10,2),
       invest_case       NUMERIC(10,2),
       financing_case    NUMERIC(10,2),
       net_case          NUMERIC(10,2),
       lastUpdateTime    DATETIME,
       reporttype        VARCHAR(2) NOT NULL,
       PRIMARY KEY((symbol,CURDATE,reporttype)
);       
/** Sql Generate **/
 DROP TABLE t_balance;

