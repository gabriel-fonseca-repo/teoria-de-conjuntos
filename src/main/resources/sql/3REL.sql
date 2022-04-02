--Relatório Mobilidade
SELECT ONI.NOME,
	ONI.DATANASCIMENTO,
	ONI.LINHASONIBUS,
	DENG.DATADENGUE
FROM TB_BUSOLOGO ONI
JOIN TB_DENGUE DENG ON ONI.NOME LIKE DENG.NOME
WHERE DENG.DATADENGUE IS NOT NULL
GROUP BY ONI.NOME,
	ONI.DATANASCIMENTO,
	ONI.LINHASONIBUS,
	DENG.DATADENGUE