package DAO;

import FileHelper.jdbcHelper;
import Model.NhanVien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO {

    public void insert(NhanVien Model) {
        String sql = "INSERT INTO NhanVien (MaNV, MatKhau, HoTen, VaiTro) VALUES (?, ?, ?, ?)";
        jdbcHelper.executeUpdate(sql,
                Model.getMaNV(),
                Model.getMatKhau(),
                Model.getHoTen(),
                Model.getVaiTro());
    }

    public void update(NhanVien model) {
        String sql = "UPDATE NhanVien SET MatKhau=?, HoTen=?, VaiTro=? WHERE MaNV=?";
        jdbcHelper.executeUpdate(sql,
                model.getMatKhau(),
                model.getHoTen(),
                model.getVaiTro(),
                model.getMaNV());
    }

    public void delete(String MaNV) {
        String sql = "DELETE FROM NhanVien WHERE MaNV=?";
        jdbcHelper.executeUpdate(sql, MaNV);
    }

    public List<NhanVien> select() {
        String sql = "SELECT * FROM NhanVien";
        return select(sql);
    }

    public NhanVien findById(String manv) {
        String sql = "SELECT * FROM NhanVien WHERE MaNV=?";
        List<NhanVien> list = select(sql, manv);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<NhanVien> select(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = jdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    NhanVien model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                try {
                    rs.getStatement().getConnection().close();
                } catch (Exception exception) {
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    private NhanVien readFromResultSet(ResultSet rs) throws SQLException {
        NhanVien model = new NhanVien();
        model.setMaNV(rs.getString("MaNV"));
        model.setMatKhau(rs.getString("MatKhau"));
        model.setHoTen(rs.getString("HoTen"));
        model.setVaiTro(rs.getBoolean("VaiTro"));
        return model;
    }
}
