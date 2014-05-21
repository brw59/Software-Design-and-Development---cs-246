private void generateStandardRow(ResultSet rs, ResultSetMetaData rsmd, int numCols, StringBuffer out) throws SQLException {

    NumberFormat formatter = NumberFormat.getCurrencyInstance();
    out.append("<TR>");

    for (int i = 1; i <= numCols; i++) {
        Object obj = rs.getObject(i);
        if ((obj != null) && (rsmd.getColumnType(i) == java.sql.Types.DOUBLE))
            out.append("<TD align='right'> " + formatter.format(rs.getDouble(i)));
        else if (obj == null)
            out.append("<TD>&nbsp;");
        else
            out.append("<TD>" + obj.toString());
    }
}