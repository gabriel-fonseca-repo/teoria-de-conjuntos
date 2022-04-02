--9 Relatório nome, data de nascimento, data que tiveram dengue dos cidadãos de XPTO que frequentaram o posto de saúde, mas não frequentaram a escola.
SELECT DENG.NOME,
	DENG.DATANASCIMENTO,
	DENG.DATADENGUE,
	ALU.NOME
FROM TB_DENGUE DENG
LEFT JOIN TB_ALUNO ALU ON ALU.NOME LIKE DENG.NOME
WHERE ALU.NOME IS NULL