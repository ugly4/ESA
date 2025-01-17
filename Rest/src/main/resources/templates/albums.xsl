<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html" encoding="UTF-8" indent="yes"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>Albums</title>
            </head>
            <body>
                <h1>Albums</h1>
                <table border="1">
                    <tr>
                        <th>Artist</th>
                        <th>Title</th>
                        <th>Year</th>
                        <th>Genre</th>
                        <th>Label</th>
                    </tr>
                    <xsl:for-each select="albums/album">
                        <tr>
                            <td><xsl:value-of select="artist"/></td>
                            <td><xsl:value-of select="name"/></td>
                            <td><xsl:value-of select="year"/></td>
                            <td><xsl:value-of select="genre"/></td>
                            <td><xsl:value-of select="label"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
