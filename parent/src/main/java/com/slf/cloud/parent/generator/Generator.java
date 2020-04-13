package com.golden.bdp.wcwl.generator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.OracleTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.golden.bdp.wcwl.core.action.BaseBdpAction;
import com.golden.bdp.wcwl.core.mapper.BaseBdpMapper;
import com.golden.bdp.wcwl.core.service.BaseBdpService;
import com.golden.bdp.wcwl.core.service.IBaseBdpService;

public class Generator {
	public static void main(String[] args) {
    	AutoGenerator mpg = new AutoGenerator();
//	        Properties props = getProperties();
        
		String outputDir = "D://generator";
//		String[] tablePrefixArray={"T_" };
//		String[] tableIncludeArray={ "BASIC_AREA","BASIC_DEPT","BASIC_EMPLOYEE","BASIC_MEMBER","BASIC_ORG","CONFIG_BUTTON","CONFIG_DATAPER","CONFIG_PERMISSION","SYSTEM_DATAPER","SYSTEM_OPERATOR","SYSTEM_OP_DATAPER","SYSTEM_OP_PERMISSION","SYSTEM_RO_DATAPER","SYSTEM_ROLE","SYSTEM_RO_PERMISSION","SYSTEM_SETTING","SYS_TIME","V_BUTPERMISSION_ALLOT","V_BUTPERMISSION_ALLOT_DETAIL","V_DATAPER","V_PERMISSION_ALLOT","V_PERMISSION_ALLOT_DATA","V_PERMISSION_ALLOT_DETAIL"};
		String table="System_Billcode".toUpperCase();
		String[] tableIncludeArray={table };
		final String viewOutputDir = outputDir;
		

		
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(outputDir);
        gc.setFileOverride(true);
        gc.setActiveRecord(false);
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        gc.setAuthor("slf");
        
        // 自定义文件命名，注意 %s 会自动填充表实体属性！
		gc.setMapperName("%sDao");		//?Mapper.java文件命名
		gc.setXmlName("%sMapper");			//?Mapper.xml文件命名
		gc.setServiceName("%sService");	//?Service.java文件命名
		gc.setServiceImplName("%sServiceImpl");	//?ServiceImpl.java文件命名
		gc.setControllerName("%sController");	//?Controller.java文件命名
        mpg.setGlobalConfig(gc);
        Generator gen = new Generator();
        Generator.DIYproperties DIY = gen.new DIYproperties();
        DIY.setFacadeName("systemPrintlog"+"Facade");//?facade.java文件命名
        DIY.setFacadeImplName("systemPrintlog"+"FacadeImpl");//?facadeImpl.java文件命名
        
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.ORACLE);
        dsc.setTypeConvert(new OracleTypeConvert() {
        	  @Override
              public DbColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                  System.out.println("转换类型：" + fieldType);
                  // 注意！！processTypeConvert 存在默认类型转换，如果不是你要的效果请自定义返回、非如下直接返回。
                  String t = fieldType.toUpperCase();
                  if (t.contains("CHAR")) {
                      return DbColumnType.STRING;
                  } else if (t.contains("DATE") || t.contains("TIMESTAMP")) {
                      return DbColumnType.DATE;
                  } else if (t.contains("NUMBER")) {
                      if (t.matches("NUMBER\\(+\\d\\)")) {
                          return DbColumnType.INTEGER;
                      } else if (t.matches("NUMBER\\(+\\d{2}+\\)")) {
                          return DbColumnType.LONG;
                      } else if (t.equals("NUMBER")) {
                          return DbColumnType.LONG;
                      }
                      
                      return DbColumnType.DOUBLE;
                  } else if (t.contains("FLOAT")) {
                      return DbColumnType.FLOAT;
                  } else if (t.contains("clob")) {
                      return DbColumnType.CLOB;
                  } else if (t.contains("BLOB")) {
                      return DbColumnType.OBJECT;
                  } else if (t.contains("binary")) {
                      return DbColumnType.BYTE_ARRAY;
                  } else if (t.contains("RAW")) {
                      return DbColumnType.BYTE_ARRAY;
                  }else if (t.toUpperCase().contains("SMALLINT")) {
                      return DbColumnType.INTEGER;
                  }
                  return DbColumnType.STRING;
                  
//	                  return super.processTypeConvert(fieldType);
              }        	
        });
        dsc.setDriverName("oracle.jdbc.driver.OracleDriver");
        dsc.setUrl("jdbc:oracle:thin:@192.168.2.92:1521:orcl");
        dsc.setUsername("zjwcn");
        dsc.setPassword("zjwcn");
        mpg.setDataSource(dsc);
        
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setCapitalMode(true);// 全局大写命名 ORACLE 注意
//        strategy.setTablePrefix(tablePrefixArray);// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setInclude(tableIncludeArray); // 需要生成的表
        
        // strategy.setExclude(new String[]{"test"}); // 排除生成的表
        // 自定义实体父类
        strategy.setSuperControllerClass(BaseBdpAction.class);
        strategy.setSuperMapperClass(BaseBdpMapper.class.getName());
        strategy.setSuperServiceImplClass(BaseBdpService.class.getName());
        strategy.setSuperServiceClass(IBaseBdpService.class.getName());
        // 自定义实体，公共字段
        strategy.setLogicDeleteFieldName("DELETE_FLAG");
        strategy.setVersionFieldName("DATA_VERSION");
        List<TableFill> tableFillList=new ArrayList<TableFill>();
        tableFillList.add(new TableFill("OPERATOR_CODE",FieldFill.INSERT));
        tableFillList.add(new TableFill("DATA_SYSTEMDATE",FieldFill.INSERT));
        tableFillList.add(new TableFill("MODIFY_OPERATOR",FieldFill.INSERT_UPDATE));
        tableFillList.add(new TableFill("MODIFY_TIME",FieldFill.INSERT_UPDATE));
        strategy.setTableFillList(tableFillList);
        
        mpg.setStrategy(strategy);
        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.golden.ldp.wcwl.portal");
        
        pc.setEntity("model");
        pc.setMapper("dao");
        pc.setController("controller");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        
        mpg.setPackageInfo(pc);
        
 
		// 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
		InjectionConfig cfg = new InjectionConfig() {
			@Override
			public void initMap() {}
		};
		// 生成的模版路径，不存在时需要先新建
		File viewDir = new File(viewOutputDir);
		if (!viewDir.exists()) {
			viewDir.mkdirs();
		}
		List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
//		focList.add(new FileOutConfig("conf/dev/templates/add.jsp.vm") {
//			@Override
//			public String outputFile(TableInfo tableInfo) {
//				return getGeneratorViewPath(viewOutputDir,tableInfo,"", "Add.jsp");
//			}
//		});
//		focList.add(new FileOutConfig("conf/dev/templates/edit.jsp.vm") {
//			@Override
//			public String outputFile(TableInfo tableInfo) {
//				return getGeneratorViewPath(viewOutputDir, tableInfo,"", "Edit.jsp");
//			}
//		});
//		focList.add(new FileOutConfig("conf/dev/templates/list.jsp.vm") {
//			@Override
//			public String outputFile(TableInfo tableInfo) {
//				return getGeneratorViewPath(viewOutputDir, tableInfo,"", ".jsp");
//			}
//		});
		
		focList.add(new FileOutConfig("conf/dev/templates/mapper.java.vm") {
			@Override
			public String outputFile(TableInfo tableInfo) {
				return getGeneratorViewPath(viewOutputDir, tableInfo,"", "Dao.java");
			}
		});
		
		focList.add(new FileOutConfig("conf/dev/templates/service.java.vm") {
			@Override
			public String outputFile(TableInfo tableInfo) {
				return getGeneratorViewPath(viewOutputDir, tableInfo,"", "Service.java");
			}
		});

		focList.add(new FileOutConfig("conf/dev/templates/serviceImpl.java.vm") {
			@Override
			public String outputFile(TableInfo tableInfo) {
				return getGeneratorViewPath(viewOutputDir, tableInfo,"", "ServiceImpl.java");
			}
		});

		focList.add(new FileOutConfig("conf/dev/templates/controller.java.vm") {
			@Override
			public String outputFile(TableInfo tableInfo) {
				return getGeneratorViewPath(viewOutputDir, tableInfo,"", "Controller.java");
			}
		});
		
		focList.add(new FileOutConfig("conf/dev/templates/facade.java.vm") {
			@Override
			public String outputFile(TableInfo tableInfo) {
				return getGeneratorViewPath(viewOutputDir, tableInfo,DIY,"", "Facade.java");
			}
		});
		focList.add(new FileOutConfig("conf/dev/templates/facadeImpl.java.vm") {
			@Override
			public String outputFile(TableInfo tableInfo) {
				return getGeneratorViewPath(viewOutputDir, tableInfo,DIY,"", "FacadeImpl.java");
			}
		});
//			cfg.setFileOutConfigList(focList);
//			mpg.setCfg(cfg);
		
		focList.add(new FileOutConfig("conf/dev/templates/entity.java.vm") {
			@Override
			public String outputFile(TableInfo tableInfo) {
				return getGeneratorViewPath(viewOutputDir, tableInfo,"", ".java");
			}
		});
		focList.add(new FileOutConfig("conf/dev/templates/mapper.xml.vm") {
			@Override
			public String outputFile(TableInfo tableInfo) {
				return getGeneratorViewPath(viewOutputDir, tableInfo,"", "Mapper.xml");
			}
		});
		focList.add(new FileOutConfig("conf/dev/templates/util.java.vm") {
			@Override
			public String outputFile(TableInfo tableInfo) {
				return getGeneratorViewPath(viewOutputDir, tableInfo,"", "Util.java");
			}
		});
		
		cfg.setFileOutConfigList(focList);
		mpg.setCfg(cfg);
        
        // 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/templates 下面内容修改，
        // 放置自己项目的 src/main/resources/templates 目录下, 默认名称一下可以不配置，也可以自定义模板名称
        // TemplateConfig tc = new TemplateConfig();
        // tc.setController("...");
        // tc.setEntity("...");
        // tc.setMapper("...");
        // tc.setXml("...");
        // tc.setService("...");
        // tc.setServiceImpl("...");
		// 如上任何一个模块如果设置 空 OR Null 将不生成该模块。
        // mpg.setTemplate(tc);

        // 执行生成
        mpg.execute();
    }
    
	/**
	 * 页面生成的文件名
	 */
	private static String getGeneratorViewPath(String viewOutputDir,TableInfo tableInfo,String prefix, String suffix) {
		String name = StringUtils.firstToLowerCase(tableInfo.getEntityName());
		String path ;
		if(suffix.indexOf(".java")>=0) {
			path = viewOutputDir + "/" + name + "/code/" + prefix+tableInfo.getEntityName() + suffix;		
		}else {
			if(suffix.indexOf("Mapper.xml")>=0) {
				path = viewOutputDir + "/" + name + "/view/" +prefix+ tableInfo.getEntityName() + suffix;			
			}else {
				path = viewOutputDir + "/" + name + "/view/" +prefix+ name + suffix;
			}
		}
		
		File viewDir = new File(path).getParentFile();
		if (!viewDir.exists()) {
			viewDir.mkdirs();
		}
		return path;
	}
	private static String getGeneratorViewPath(String viewOutputDir,TableInfo tableInfo,DIYproperties diy, String prefix, String suffix) {
		String name = StringUtils.firstToLowerCase(tableInfo.getEntityName());
		String path ;
		if(suffix.indexOf(".java")>=0) {
			path = viewOutputDir + "/" + name + "/code/" + prefix+tableInfo.getEntityName() + suffix;		
		}else {
			if(suffix.indexOf("Mapper.xml")>=0) {
				path = viewOutputDir + "/" + name + "/view/" +prefix+ tableInfo.getEntityName() + suffix;			
			}else {
				path = viewOutputDir + "/" + name + "/view/" +prefix+ name + suffix;
			}
		}
		
		File viewDir = new File(path).getParentFile();
		if (!viewDir.exists()) {
			viewDir.mkdirs();
		}
		return path;
	}
	public class DIYproperties{
		DIYproperties() {};
		private String facadeName;
		private String facadeImplName;
		public String getFacadeImplName() {
			return facadeImplName;
		}
		public void setFacadeImplName(String facadeImplName) {
			this.facadeImplName = facadeImplName;
		}
		public String getFacadeName() {
			return facadeName;
		}
		public void setFacadeName(String facadeName) {
			this.facadeName = facadeName;
		}
		
	}

}
