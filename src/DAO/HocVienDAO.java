/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import FileHelper.jdbcHelper;
import Model.HocVien;
import Model.NhanVien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class HocVienDAO {

    public static NhanVien findById(String manv) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
public void insert(HocVien model){
String sql="INSERT INTO HocVien(MaKH, MaNH, Diem) VALUES(?, ?, ?)";
jdbcHelper.executeUpdate(sql,
model.getMaKH(),
model.getMaNH(),
model.getDiem());
}
public void update(HocVien model){
String sql="UPDATE HocVien SET MaKH=?, MaNH=?, Diem=? WHERE MaHV=?";
jdbcHelper.executeUpdate(sql,
model.getMaKH(),
model.getMaNH(),
model.getDiem(),
model.getMaHV());
}
public void delete(Integer MaHV){
String sql="DELETE FROM HocVien WHERE MaHV=?";
jdbcHelper.executeUpdate(sql, MaHV);
}
public List<HocVien> select(){
String sql="SELECT * FROM HocVien";
return select(sql);
}
public HocVien findById(Integer mahv){
String sql="SELECT * FROM HocVien WHERE MaHV=?";
List<HocVien> list = select(sql, mahv);
return list.size() > 0 ? list.get(0) : null;
}private List<HocVien> select(String sql, Object...args){
List<HocVien> list = new ArrayList<>();
try {
ResultSet rs = null;
try {
rs = jdbcHelper.executeQuery(sql, args);
while(rs.next()){
HocVien model=readFromResultSet(rs);
list.add(model);
}
}
finally{
rs.getStatement().getConnection().close();
}
}
catch (SQLException ex) {
throw new RuntimeException(ex);
}
return list;
}
private HocVien readFromResultSet(ResultSet rs) throws SQLException{
HocVien model=new HocVien();
model.setMaHV(rs.getInt("MaHV"));
model.setMaKH(rs.getInt("KH"));
model.setMaNH(rs.getString("MaNH"));
model.setDiem(rs.getDouble("Diem"));
return model;
}
}