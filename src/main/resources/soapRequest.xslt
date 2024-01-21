<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="xml" indent="yes" omit-xml-declaration="yes" encoding="UTF-8"/>
    <!-- Identity template: copy everything as is -->
    <xsl:template match="@*|node()">
        <xsl:copy>
            <xsl:apply-templates select="@*|node()"/>
        </xsl:copy>
    </xsl:template>
    <!-- Specific transformations for inquireMemberRequest -->
    <xsl:template match="/">
        <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                          xmlns:fpac="http://dhcs.ca.gov/exchange/fpact"
                          xmlns:iden="http://dhcs.ca.gov/core/common/identification"
                          xmlns:fpac1="http://dhcs.ca.gov/services/fpact-common"
                          xmlns:ns="http://niem.gov/niem/niem-core/2.0">
        <soapenv:Header/>
        <soapenv:Body>
            <fpac:inquireMemberRequest>
        <xsl:copy>
            <xsl:apply-templates select="@*"/>
            <iden:HapId>
                <iden:HapId>
                    <!-- Map HapId from Java object -->
                    <xsl:value-of select="/params/@hapIdValue"/>
                </iden:HapId>
            </iden:HapId>
            <fpac1:PersonBirthDate>
                <ns:Date>
                    <!-- Map Date from Java object -->
                    <xsl:value-of select="/params/@dateOfBirthValue"/>
                </ns:Date>
            </fpac1:PersonBirthDate>
            <fpac1:InitiatedBy>
                <fpac1:Other>
                    <!-- Constant value for initiatedBy -->
                    <xsl:value-of select="/params/@initiatedByValue"/>
                </fpac1:Other>
                <fpac1:NPI>
                    <!-- Constant value for NPI -->
                    <xsl:value-of select="/params/@npiValue"/>
                </fpac1:NPI>
            </fpac1:InitiatedBy>
            <!-- Add other transformations as needed -->
        </xsl:copy>
           </fpac:inquireMemberRequest>
        </soapenv:Body>
        </soapenv:Envelope>
    </xsl:template>
</xsl:stylesheet>