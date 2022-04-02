--8 Relatório nome, data de nascimento, data que tiveram dengue dos cidadãos de XPTO que frequentaram o posto de saúde, mas não utilizaram transporte público.
SELECT DENG.NOME,
	DENG.DATANASCIMENTO,
	DENG.DATADENGUE
FROM TB_DENGUE DENG
JOIN TB_BUSOLOGO ONI ON ONI.NOME LIKE DENG.NOME
WHERE ONI.LINHASONIBUS IS NULL
--////////////////////////////////////////////
SELECT DENG.NOME,
	DENG.DATANASCIMENTO,
	DENG.DATADENGUE,
	ONI.LINHASONIBUS
FROM TB_DENGUE DENG
JOIN TB_BUSOLOGO ONI ON ONI.NOME LIKE DENG.NOME