-- 코드를 입력하세요
SELECT PRODUCT_CODE, PRICE*SUM(SALES_AMOUNT) AS SALES
FROM PRODUCT, OFFLINE_SALE
WHERE PRODUCT.PRODUCT_ID = OFFLINE_SALE.PRODUCT_ID
GROUP BY PRODUCT_CODE
ORDER BY SALES DESC, PRODUCT_CODE ASC;