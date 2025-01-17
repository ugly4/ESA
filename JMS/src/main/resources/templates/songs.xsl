<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html" encoding="UTF-8" indent="yes"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>Songs</title>
            </head>
            <body>
                <h1>Songs</h1>
                <table border="1">
                    <tr>
                        <th>Artist</th>
                        <th>Title</th>
                        <th>Album</th>
                        <th>Duration</th>
                        <th>ExplicitContent</th>
                    </tr>
                    <xsl:for-each select="songs/song">
                        <tr>
                            <td><xsl:value-of select="artist"/></td>
                            <td><xsl:value-of select="name"/></td>
                            <td><xsl:value-of select="album"/></td>
                            <td><xsl:value-of select="duration"/></td>
                            <td><xsl:value-of select="explicitContent"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>