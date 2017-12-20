package com.sys.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.inject.Singleton;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.common.BaseController;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;


@Path("/rest/jlb")
@Component
@Singleton
@Controller
@RequestMapping("/rest/jlb")
@Api(value="/rest/jlb",description="俱乐部接口文档")
public class JlbAppAction extends BaseController {
	
//	@Autowired
//	private JlbBaseService jlbBaseService;
	
	 
	
	/**
	 * 俱乐部保存信息接口
	 * @Title saveJlb
	 * @param jlbifo
	 * @author zpj
	 * @time 2017年11月28日 上午8:52:57
	 */
//	@POST
//	@Path("/jlbSave")
//	@RequestMapping(value="/jlbSave")
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//	@ApiOperation(value = "新增保存俱乐部信息",response = JlbInfo.class, httpMethod = "POST", notes = "新增保存俱乐部信息",produces=MediaType.APPLICATION_JSON) 
//	@ResponseBody
//	public void saveJlb(@Context HttpServletResponse response,
//			@ApiParam(required = false, name = "userid", value = "注册手机用户id")@RequestParam("userid")String userid,
//			@ApiParam(required = false, name = "name", value = "俱乐部名称")@RequestParam("name")String name,
//			@ApiParam(name = "introduce", value = "介绍")@RequestParam("introduce")String introduce,
//			@ApiParam(name = "address", value = "所在地")@RequestParam("address")String address,
//			@ApiParam(name = "url", value = "图片地址路径,多个用逗号分开")@RequestParam("url")String url
//			){
//		JlbInfo jlbInfo =new JlbInfo();
//		if(jlbInfo.getId()==null||jlbInfo.getId().equalsIgnoreCase(""))
//			jlbInfo.setId(getRandomID());
//		jlbInfo.setJlbuserid(userid);
//		jlbInfo.setName(name);
//		jlbInfo.setIntroduce(introduce);
//		jlbInfo.setAddress(address);
//		jlbInfo.setCreateTime(new Date());
//		jlbInfo.setType(0);//默认线上俱乐部
//		jlbInfo.setMemberCount(0);//成员数量
//		jlbInfo.setShenhe(0);//审核字段默认0
//		jlbInfo.setUrl(url);
//		
//		boolean flag=jlbBaseService.saveJlb(jlbInfo);
//		JlbInfo retinfo=jlbBaseService.findById(jlbInfo.getId());
//		MbResultData infolist = new MbResultData();
//		if(flag){
//			infolist.setSuccess(1);
//		}else{
//			infolist.setSuccess(0);
//		}
//		infolist.setMsg("保存成功!");
//		infolist.setData(retinfo);
//		
//		responseJson(infolist);
//	}
//	
//	/**
//	 * 根据俱乐部Id查询俱乐部信息
//	 * @Title findJlbById
//	 * @param id
//	 * @author zpj
//	 * @time 2017年11月28日 上午9:15:54
//	 */
//	@POST
//	@Path("/findJlbById")
//	@RequestMapping(value="/findJlbById")
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//	@ApiOperation(value = "根据id查询俱乐部信息",response =String.class, httpMethod = "POST", notes = "根据id查询俱乐部信息",produces="application/json") 
//	@ResponseBody
//	public void findJlbById(
//			@ApiParam(required = false, name = "userid", value = "注册手机用户id")@RequestParam("userid")String userid,
//			@ApiParam(required = false,name = "id", value = "俱乐部id")@RequestParam("id")String id){
//		JlbInfo jlbInfo=null;
//		if(id!=null&&!id.equalsIgnoreCase("")){
//			jlbInfo=jlbBaseService.findById(id);
//			List list=jlbBaseService.findJlbMemberByJlbId(id);
//			jlbInfo.setUseridList(list);
//		}
//		MbResultData infolist = new MbResultData();
//		if(jlbInfo!=null){
//			infolist.setSuccess(1);
//		}else{
//			infolist.setSuccess(0);
//		}
//		infolist.setMsg("获取信息成功!");
//		infolist.setData(jlbInfo);
//		responseJson(infolist);
//		
//	}
//	
//	/**
//	 * 根据主键查询相册信息
//	 * @Title findAlbumById
//	 * @param userid
//	 * @param id
//	 * @author zpj
//	 * @time 2017年12月2日 下午1:46:51
//	 */
//	@POST
//	@Path(value = "/findAlbumById")
//	@RequestMapping(value="/findAlbumById" )
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//	@ApiOperation(value = "根据相册id查询相册信息",response =JlbAlbumInfo.class, httpMethod = "POST", notes = "根据相册id查询相册信息",produces="application/json") 
//	@ResponseBody
//	public void  findAlbumById(@ApiParam(required = false, name = "userid", value = "注册手机用户id")@RequestParam("userid")String userid,
//			@ApiParam(required = false, name = "id", value = "相册Id")@RequestParam("id")String id){
//		JlbAlbumInfo album=jlbBaseService.findAlbumById(id);
////		album.setGlanceNum(album.getGlanceNum()+1);
////		jlbBaseService.saveAlbum(album);
//		MbResultData infolist = new MbResultData();
//		if(album!=null){
//			infolist.setSuccess(1);
//		}else{
//			infolist.setSuccess(0);
//		}
//		infolist.setMsg("查询成功");
//		infolist.setData(album);
//		responseJson(infolist);
//	}
//	
//	/**
//	 * 根据相册id更新浏览量
//	 * @Title updateAlbumGlanceNumById
//	 * @param userid
//	 * @param id
//	 * @author zpj
//	 * @time 2017年12月12日 上午10:15:51
//	 */
//	@POST
//	@Path(value = "/updateAlbumGlanceNumById")
//	@RequestMapping(value="/updateAlbumGlanceNumById" )
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//	@ApiOperation(value = "更新浏览相册的数量",response =JlbAlbumInfo.class, httpMethod = "POST", notes = "更新浏览相册的数量",produces="application/json") 
//	@ResponseBody
//	public void  updateAlbumGlanceNumById(@ApiParam(required = false, name = "userid", value = "注册手机用户id")@RequestParam("userid")String userid,
//			@ApiParam(required = false, name = "id", value = "相册Id")@RequestParam("id")String id){
//		boolean flag=jlbBaseService.updateAlbumGlanceNumById(id);
//		JlbAlbumInfo album=jlbBaseService.findAlbumById(id);
//		MbResultData infolist = new MbResultData();
//		if(flag){
//			infolist.setSuccess(1);
//		}else{
//			infolist.setSuccess(0);
//		}
//		infolist.setData(album);
//		infolist.setMsg("更新成功");
//		responseJson(infolist);
//	}
//	
//	
//	/**
//	 * 更新文章浏览量字段
//	 * @Title updateArticleGlanceCountById
//	 * @param userid
//	 * @param id
//	 * @author zpj
//	 * @time 2017年12月13日 下午2:15:25
//	 */
//	@POST
//	@Path(value = "/updateArticleGlanceCountById")
//	@RequestMapping(value="/updateArticleGlanceCountById" )
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//	@ApiOperation(value = "更新浏览文章浏览数量",response =JlbAlbumInfo.class, httpMethod = "POST", notes = "更新浏览文章浏览数量",produces="application/json") 
//	@ResponseBody
//	public void  updateArticleGlanceCountById(@ApiParam(required = false, name = "userid", value = "注册手机用户id")@RequestParam("userid")String userid,
//			@ApiParam(required = false, name = "id", value = "文章Id")@RequestParam("id")String id){
//		boolean flag=jlbBaseService.updateArticleGlanceCountById(id);
//		JlbArticleInfo article=jlbBaseService.findArticleById(id);
//		MbResultData infolist = new MbResultData();
//		if(flag){
//			infolist.setSuccess(1);
//		}else{
//			infolist.setSuccess(0);
//		}
//		infolist.setData(article);
//		infolist.setMsg("更新成功");
//		responseJson(infolist);
//	}
//	
//	/**
//	 * 根据主键查询文章信息
//	 * @Title findArticleById
//	 * @param userid
//	 * @param id
//	 * @author zpj
//	 * @time 2017年12月2日 下午1:48:40
//	 */
//	@POST
//	@Path(value = "/findArticleById")
//	@RequestMapping(value="/findArticleById" )
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//	@ApiOperation(value = "根据文章id查询文章信息",response =JlbArticleInfo.class, httpMethod = "POST", notes = "根据文章id查询文章信息",produces="application/json") 
//	@ResponseBody
//	public void  findArticleById(@ApiParam(required = false, name = "userid", value = "注册手机用户id")@RequestParam("userid")String userid,
//			@ApiParam(required = false, name = "id", value = "文章Id")@RequestParam("id")String id){
//		
//		JlbArticleInfo article=jlbBaseService.findArticleById(id);
////		article.setGlanceCount(article.getGlanceCount()+1);
////		jlbBaseService.saveArticle(article);
//		MbResultData infolist = new MbResultData();
//		if(article!=null){
//			infolist.setSuccess(1);
//		}else{
//			infolist.setSuccess(0);
//		}
//		infolist.setMsg("查询成功");
//		infolist.setData(article);
//		responseJson(infolist);
//	}
//	
//	@POST
//	@Path(value = "/findMemberById")
//	@RequestMapping(value="/findMemberById" )
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//	@ApiOperation(value = "根据用户id查询用户对象（头像信息）",response =String.class, httpMethod = "POST", notes = "根据用户id查询用户对象（头像信息）",produces="application/json") 
//	@ResponseBody
//	public void  findMemberById(@ApiParam(required = false, name = "userid", value = "注册手机用户id")@RequestParam("userid")String userid
//			){
//		Map map=jlbBaseService.findMemberById(userid);
//		MbResultData infolist = new MbResultData();
//		if(map!=null){
//			infolist.setSuccess(1);
//		}else{
//			infolist.setSuccess(0);
//		}
//		infolist.setMsg("查询成功");
//		infolist.setData(map);
//		responseJson(infolist);
//	}
//	
//	
//	@POST
//	@Path(value = "/findArticleCommentInfoByArticleId")
//	@RequestMapping(value="/findArticleCommentInfoByArticleId" )
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//	@ApiOperation(value = "根据根据文章id查询文章评论信息",response =JlbArticleCommentInfo.class, httpMethod = "POST", notes = "根据根据文章id查询文章评论信息",produces="application/json") 
//	@ResponseBody
//	public void  findArticleCommentInfoByArticleId(@ApiParam(required = false, name = "userid", value = "注册手机用户id")@RequestParam("userid")String userid,
//			@ApiParam(required = false, name = "id", value = "文章Id")@RequestParam("id")String id){
//		
//		List<Map> list=jlbBaseService.findArticleCommentByArticleId(id);
//		MbResultData infolist = new MbResultData();
//		if(list!=null&&list.size()>0){
//			infolist.setSuccess(1);
//		}else{
//			infolist.setSuccess(0);
//		}
//		infolist.setMsg("查询成功");
//		infolist.setData(list);
//		responseJson(infolist);
//	}
//	
////	@POST
////	@Path(value = "/addArticleCommentInfoByArticleId")
////	@RequestMapping(value="/addArticleCommentInfoByArticleId" )
////	@Produces(MediaType.APPLICATION_JSON)
////	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
////	@ApiOperation(value = "保存文章评论信息",response =JlbArticleCommentInfo.class, httpMethod = "POST", notes = "保存文章评论信息",produces="application/json") 
////	@ResponseBody
////	public void  addArticleCommentInfoByArticleId(@ApiParam(required = false, name = "userid", value = "注册手机用户id")@RequestParam("userid")String userid,
////			@ApiParam(required = false, name = "articleId", value = "文章Id")@RequestParam("articleId")String articleId){
////		
////		List<Map> list=jlbBaseService.findArticleCommentByArticleId(id);
////		MbResultData infolist = new MbResultData();
////		if(list!=null&&list.size()>0){
////			infolist.setSuccess(1);
////		}else{
////			infolist.setSuccess(0);
////		}
////		infolist.setMsg("查询成功");
////		infolist.setData(list);
////		responseJson(infolist);
////	}
//	
//	
//	/**
//	 * 保存关联俱乐部的相册信息
//	 * @Title saveAlbum
//	 * @param name
//	 * @param jlbId
//	 * @author zpj
//	 * @time 2017年11月29日 下午2:47:51
//	 */
//	@POST
//	@Path(value = "/saveAlbum")
//	@RequestMapping(value="/saveAlbum" )
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//	@ApiOperation(value = "新增保存相册信息",response = JlbAlbumInfo.class, httpMethod = "POST", notes = "新增保存相册信息",produces="application/json") 
//	@ResponseBody
//	public void saveAlbum(
//						  @ApiParam(required = false, name = "userid", value = "注册手机用户id")@RequestParam("userid")String userid,
//						  @ApiParam(required = false, name = "name", value = "相册名称")@RequestParam("name")String name,
//						  @ApiParam(required = false, name = "jlbid", value = "俱乐部id")@RequestParam("jlbid")String jlbid
//						 
//						  ){
//		
//		JlbAlbumInfo jlbAlbumInfo=new JlbAlbumInfo();
//		jlbAlbumInfo.setId(UUID.randomUUID().toString());
//		jlbAlbumInfo.setCreateTime(new Date());
//		jlbAlbumInfo.setJlbId(jlbid);
//		jlbAlbumInfo.setName(name);
//		jlbAlbumInfo.setUserid(userid);
////		jlbAlbumInfo.setUrl(url);
////		int picNum=url.split(",").length;
//		jlbAlbumInfo.setPicNum(0);
////		jlbAlbumInfo.setGlanceNum(glanceNum);
//		
//		boolean flag=jlbBaseService.saveAlbum(jlbAlbumInfo);
//		JlbAlbumInfo album=jlbBaseService.findAlbumById(jlbAlbumInfo.getId());
//		MbResultData infolist = new MbResultData();
//		if(flag){
//			infolist.setSuccess(1);
//			infolist.setMsg("保存成功!");
//		}else{
//			infolist.setSuccess(0);
//			infolist.setMsg("保存失败!");
//		}
//		infolist.setData(album);
//		responseJson(infolist);
//		
//	}
//	
//	/**
//	 * 往相册里面添加图片
//	 * @Title addPhotoInAlbum
//	 * @param userid
//	 * @param albumId
//	 * @param url
//	 * @author zpj
//	 * @time 2017年12月11日 下午1:40:01
//	 */
//	@POST
//	@Path(value = "/addPhotoInAlbum")
//	@RequestMapping(value="/addPhotoInAlbum" )
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//	@ApiOperation(value = "相册保存图片信息",response = JlbAlbumInfo.class, httpMethod = "POST", notes = "相册保存图片信息",produces="application/json") 
//	@ResponseBody
//	public void addPhotoInAlbum(
//						  @ApiParam(required = false, name = "userid", value = "注册手机用户id")@RequestParam("userid")String userid,
//						  @ApiParam(required = false, name = "albumId", value = "相册id")@RequestParam("albumId")String albumId,
//						  @ApiParam(name = "url", value = "图片地址路径,多个用逗号分开")@RequestParam("url")String url
//						  ){
//		JlbAlbumPicInfo japi=null;
//		String[] urlArr=url.split(",");
//		boolean flag=false;
//		for(int m=0;m<urlArr.length;m++){
//			japi=new JlbAlbumPicInfo();
//			japi.setId(UUID.randomUUID().toString());
//			japi.setAlbumId(albumId);
//			japi.setCreateTime(new Date());
//			japi.setUrl(urlArr[m]);
//			flag=jlbBaseService.addPhotoInAlbum(japi);
//			if(!flag){
//				break;
//			}
//		}
//		jlbBaseService.updateAlbumCount(albumId,true,urlArr.length);
////		JlbAlbumInfo album=jlbBaseService.findAlbumById(albumId);
//		MbResultData infolist = new MbResultData();
//		if(flag){
//			infolist.setSuccess(1);
//			infolist.setMsg("保存成功!");
//		}else{
//			infolist.setSuccess(0);
//			infolist.setMsg("保存失败!");
//		}
//		responseJson(infolist);
//		
//	}
//	
//	@POST
//	@Path(value = "/deletePhotoOutOfAlbum")
//	@RequestMapping(value="/deletePhotoOutOfAlbum" )
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//	@ApiOperation(value = "删除相册图片信息",response = JlbAlbumInfo.class, httpMethod = "POST", notes = "删除相册图片信息",produces="application/json") 
//	@ResponseBody
//	public void deletePhotoOutOfAlbum(
//						  @ApiParam(required = false, name = "userid", value = "注册手机用户id")@RequestParam("userid")String userid,
//						  @ApiParam(required = false, name = "albumId", value = "相册id")@RequestParam("albumId")String albumId,
//						  @ApiParam(name = "id", value = "单张图片id，如果删除多个 用逗号分割")@RequestParam("id")String id
//						  ){
//		JlbAlbumPicInfo japi=null;
//		
//		boolean flag=jlbBaseService.deletePhotoOutOfAlbum(albumId,id);
//		int count=id.split(",").length;
//		jlbBaseService.updateAlbumCount(albumId,false,count);
//		//JlbAlbumInfo album=jlbBaseService.findAlbumById(albumId);
//		MbResultData infolist = new MbResultData();
//		if(flag){
//			infolist.setSuccess(1);
//			infolist.setMsg("保存成功!");
//		}else{
//			infolist.setSuccess(0);
//			infolist.setMsg("保存失败!");
//		}
//		responseJson(infolist);
//		
//	}
//	
//	/**
//	 * 保存评论信息
//	 * @Title saveArticleComment
//	 * @param userid
//	 * @param comment
//	 * @param articleId
//	 * @author zpj
//	 * @time 2017年12月2日 下午4:08:47
//	 */
//	@POST
//	@Path(value = "/saveArticleComment")
//	@RequestMapping(value="/saveArticleComment" )
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//	@ApiOperation(value = "新增保存文章评论信息",response = JlbArticleCommentInfo.class, httpMethod = "POST", notes = "新增保存文章评论信息",produces="application/json") 
//	@ResponseBody
//	public void saveArticleComment(
//						  @ApiParam(required = false, name = "userid", value = "注册手机用户id")@RequestParam("userid")String userid,
//						  @ApiParam(required = false, name = "comment", value = "评论信息")@RequestParam("comment")String comment,
//						  @ApiParam(required = false, name = "articleId", value = "文章id")@RequestParam("articleId")String articleId
//						  ){
//		JlbArticleCommentInfo info=new JlbArticleCommentInfo();
//		info.setId(UUID.randomUUID().toString());
//		info.setArticleId(articleId);
//		info.setCreateTime(new Date());
//		info.setComment(comment);
//		info.setCommentUserid(userid);
//		boolean flag=jlbBaseService.saveArticleComment(info);
//		MbResultData infolist = new MbResultData();
//		if(flag){
//			jlbBaseService.updateArticleCommentCount(articleId,true);
//			infolist.setSuccess(1);
//		}else{
//			infolist.setSuccess(0);
//		}
//		infolist.setMsg("保存成功!");
//		infolist.setData(info);
//		responseJson(infolist);
//		
//	}
//	
//	
//	/**
//	 * 删除关联俱乐部的相册信息
//	 * @Title deleteAlbum
//	 * @author zpj
//	 * @time 2017年11月29日 下午2:50:37
//	 */
//	@POST
//	@Path(value = "/deleteAlbum")
//	@RequestMapping(value="/deleteAlbum" )
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//	@ApiOperation(value = "根据相册id删除相册信息", httpMethod = "POST", notes = "根据相册id删除相册信息",produces="application/json") 
//	@ResponseBody
//	public void deleteAlbum(
//				@ApiParam(required = false, name = "userid", value = "注册手机用户id")@RequestParam("userid")String userid,
//				@ApiParam(required = false, name = "id", value = "删除俱乐部相册Id")@RequestParam("id")String id
//			){
//		boolean flag=jlbBaseService.deleteAlbum(id);
//		MbResultData infolist = new MbResultData();
//		if(flag){
//			infolist.setSuccess(1);
//		}else{
//			infolist.setSuccess(0);
//		}
//		infolist.setMsg("删除相册成功");
//		responseJson(infolist);
//	}
//	
//	
//	/**
//	 * 保存关联俱乐部的文章信息
//	 * @Title saveArticle
//	 * @author zpj
//	 * @time 2017年11月29日 下午2:49:46
//	 */
//	
//	@POST
//	@Path(value = "/saveArticle")
//	@RequestMapping(value="/saveArticle" )
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//	@ApiOperation(value = "保存文章信息", response = JlbArticleInfo.class, httpMethod = "POST", notes = "保存文章信息",produces="application/json") 
//	@ResponseBody
//	public void saveArticle(@ApiParam(required = false, name = "userid", value = "注册手机用户id")@RequestParam("userid")String userid,
//			  @ApiParam(required = false,name = "title", value = "文章标题")@RequestParam("title")String title,
//			  @ApiParam(name = "content", value = "文章内容")@RequestParam("content")String content,
//			  @ApiParam(name = "url", value = "文章图片路径,多个用逗号分割")@RequestParam("url")String url,
//			  @ApiParam(name = "jlbid", value = "俱乐部id")@RequestParam("jlbid")String jlbid){
//		JlbArticleInfo article= new JlbArticleInfo();
//		article.setId(UUID.randomUUID().toString());
//		article.setContent(content);
//		article.setJlbId(jlbid);
//		article.setCreateTime(new Date());
//		article.setPublishUserid(userid);
//		article.setPublishUsername("");
//		article.setGlanceCount(0);
//		article.setTitle(title);
//		article.setUrl(url);
//		boolean flag=jlbBaseService.saveArticle(article);
//		JlbArticleInfo art=null;
//		if(flag){
//			art=jlbBaseService.findArticleById(article.getId());
//		}
//		
//		MbResultData infolist = new MbResultData();
//		if(flag){
//			infolist.setSuccess(1);
//		}else{
//			infolist.setSuccess(0);
//		}
//		infolist.setMsg("删除相册成功");
//		infolist.setData(art);
//		responseJson(infolist);
//	}
//	
//	/**
//	 * 删除关联俱乐部的文章信息
//	 * @Title deleteArticle
//	 * @author zpj
//	 * @time 2017年11月29日 下午2:51:19
//	 */
//	@POST
//	@Path(value = "/deleteArticle")
//	@RequestMapping(value="/deleteArticle" )
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//	@ApiOperation(value = "根据文章id删除文章信息", httpMethod = "POST", notes = "根据文章id删除文章信息",produces="application/json") 
//	@ResponseBody
//	public void deleteArticle(@ApiParam(required = false, name = "userid", value = "注册手机用户id")@RequestParam("userid")String userid,
//			  				  @ApiParam(required = false, name = "id", value = "删除俱乐部文章")@RequestParam("id")String id){
//		boolean flag=jlbBaseService.deleteArticle(id);
//		MbResultData infolist = new MbResultData();
//		if(flag){
//			infolist.setSuccess(1);
//		}else{
//			infolist.setSuccess(0);
//		}
//		infolist.setMsg("删除文章成功");
//		responseJson(infolist);
//	}
//	
//	@POST
//	@Path(value = "/deleteArticleComment")
//	@RequestMapping(value="/deleteArticleComment" )
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//	@ApiOperation(value = "删除文章评论信息", httpMethod = "POST", notes = "删除文章评论信息",produces="application/json") 
//	@ResponseBody
//	public void deleteArticleComment(@ApiParam(required = false, name = "userid", value = "注册手机用户id")@RequestParam("userid")String userid,
//			  				  @ApiParam(required = false, name = "id", value = "文章评论id")@RequestParam("id")String id,
//			  				@ApiParam(required = false, name = "articleId", value = "文章id")@RequestParam("articleId")String articleId){
//		boolean flag=jlbBaseService.deleteArticleComment(id);
//		
//		MbResultData infolist = new MbResultData();
//		if(flag){
//			jlbBaseService.updateArticleCommentCount(articleId,false);
//			infolist.setSuccess(1);
//		}else{
//			infolist.setSuccess(0);
//		}
//		infolist.setMsg("删除文章成功");
//		responseJson(infolist);
//	}
//	
//	/**
//	 * 查询相册信息根据当前用户
//	 * @Title findJlbByUser
//	 * @author zpj
//	 * @time 2017年11月29日 下午2:53:12
//	 */
//	@POST
//	@Path(value = "/findAlbumByUser")
//	@RequestMapping(value="/findAlbumByUser" )
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//	@ApiOperation(value = "根据用户id查询关联的俱乐部的相册信息",response = JlbAlbumInfo.class, httpMethod = "POST", notes = "根据用户id查询关联的俱乐部的相册信息",produces="application/json") 
//	@ResponseBody
//	public void findAlbumByUser(@ApiParam(required = false, name = "userid", value = "注册手机用户id")@RequestParam("userid")String userid){
//		List list=jlbBaseService.findAlbumByUserId(userid);
//		MbResultData infolist = new MbResultData();
//		if(list!=null){
//			infolist.setSuccess(1);
//		}else{
//			infolist.setSuccess(0);
//		}
//		infolist.setMsg("查询成功");
//		infolist.setData(list);
//		responseJson(infolist);
//	}
//	
//	/**
//	 * 查询文章信息根据当前用户
//	 * @Title findJlbByUser
//	 * @author zpj
//	 * @time 2017年11月29日 下午2:53:12
//	 */
//	@POST
//	@Path(value = "/findArticleByUser")
//	@RequestMapping(value="/findArticleByUser" )
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//	@ApiOperation(value = "根据用户id查询关联的俱乐部的文章信息",response = JlbArticleInfo.class, httpMethod = "POST", notes = "根据用户id查询关联的俱乐部的文章信息",produces="application/json") 
//	@ResponseBody
//	public void findArticleByUser(@ApiParam(required = false, name = "userid", value = "注册手机用户id")@RequestParam("userid")String userid){
//		List list=jlbBaseService.findArticleByUserid(userid);
//		MbResultData infolist = new MbResultData();
//		if(list!=null){
//			infolist.setSuccess(1);
//		}else{
//			infolist.setSuccess(0);
//		}
//		infolist.setMsg("查询成功");
//		infolist.setData(list);
//		responseJson(infolist);
//	}
//	
//	/**
//	 * 根据用户查询俱乐部列表信息
//	 * @Title findJlbByUser
//	 * @param userid
//	 * @author zpj
//	 * @time 2017年12月2日 下午1:19:41
//	 */
//	@POST
//	@Path(value = "/findJlbFindByUser")
//	@RequestMapping(value="/findJlbFindByUser" )
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//	@ApiOperation(value = "根据用户id查询关联的俱乐部信息",response = JlbInfo.class, httpMethod = "POST", notes = "根据用户id查询关联的俱乐部信息",produces=MediaType.APPLICATION_JSON) 
//	@ResponseBody
//	public void  findJlbByUser(@ApiParam(required = false, name = "userid", value = "注册手机用户id")@RequestParam("userid")String userid){
//		List<Map> list=jlbBaseService.findJlbByUserid(userid);
//		MbResultData<List<Map>> infolist = new MbResultData();
//		if(list!=null){
//			infolist.setSuccess(1);
//		}else{
//			infolist.setSuccess(0);
//		}
//		infolist.setMsg("查询成功");
//		infolist.setData(list);
//		responseJson(infolist);
//	}
//	
//	
//	/**
//	 * 根据俱乐部查询相册信息
//	 * @Title findAlbumByJlb
//	 * @param userid
//	 * @author zpj
//	 * @time 2017年12月2日 下午1:20:04
//	 */
//	@POST
//	@Path(value = "/findAlbumByJlb")
//	@RequestMapping(value="/findAlbumByJlb" )
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//	@ApiOperation(value = "根据俱乐部id查询关联的俱乐部的相册信息", httpMethod = "POST", notes = "根据俱乐部id查询关联的俱乐部的相册信息",produces="application/json") 
//	@ResponseBody
//	public void  findAlbumByJlb(@ApiParam(required = false, name = "userid", value = "注册手机用户id")@RequestParam("userid")String userid,
//			@ApiParam(required = false, name = "jlbid", value = "俱乐部id信息")@RequestParam("jlbid")String jlbid){
//		
//		List<Map> list=jlbBaseService.findAlbumByJlb(jlbid);
//		MbResultData infolist = new MbResultData();
//		if(list!=null){
//			infolist.setSuccess(1);
//		}else{
//			infolist.setSuccess(0);
//		}
//		infolist.setMsg("查询成功");
//		infolist.setData(list);
//		responseJson(infolist);
//	}
//	
//	
//	@POST
//	@Path(value = "/findPhotoByAlbumId")
//	@RequestMapping(value="/findPhotoByAlbumId" )
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//	@ApiOperation(value = "根据相册id查询关联的图片列表",response=JlbAlbumPicInfo.class, httpMethod = "POST", notes = "根据相册id查询关联的图片列表",produces="application/json") 
//	@ResponseBody
//	public void  findPhotoByAlbumId(@ApiParam(required = false, name = "userid", value = "注册手机用户id")@RequestParam("userid")String userid,
//			@ApiParam(required = false, name = "albumId", value = "相册id信息")@RequestParam("albumId")String albumId){
//		
//		List<Map> list=jlbBaseService.findPhotoByAlbumId(albumId);
//		MbResultData infolist = new MbResultData();
//		if(list!=null){
//			infolist.setSuccess(1);
//		}else{
//			infolist.setSuccess(0);
//		}
//		infolist.setMsg("查询成功");
//		infolist.setData(list);
//		responseJson(infolist);
//	}
//	
//	
//	
//	@POST
//	@Path(value = "/findArticleByJlb")
//	@RequestMapping(value="/findArticleByJlb" )
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//	@ApiOperation(value = "根据俱乐部id查询关联的俱乐部的文章信息",response=JlbArticleInfo.class, httpMethod = "POST", notes = "根据俱乐部id查询关联的俱乐部的文章信息",produces="application/json") 
//	@ResponseBody
//	public void  findArticleByJlb(@ApiParam(required = false, name = "userid", value = "注册手机用户id")@RequestParam("userid")String userid,
//			@ApiParam(required = false, name = "jlbid", value = "俱乐部id信息")@RequestParam("jlbid")String jlbid){
//		
//		List<Map> list=jlbBaseService.findArticleByJlb(jlbid);
//		MbResultData infolist = new MbResultData();
//		if(list!=null){
//			infolist.setSuccess(1);
//		}else{
//			infolist.setSuccess(0);
//		}
//		infolist.setMsg("查询成功");
//		infolist.setData(list);
//		responseJson(infolist);
//	}
//	
//	
//	@POST
//	@Path(value = "/addPeopleInJlb")
//	@RequestMapping(value="/addPeopleInJlb" )
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//	@ApiOperation(value = "加入俱乐部", httpMethod = "POST", notes = "加入俱乐部",produces="application/json") 
//	@ResponseBody
//	public void  addPeopleInJlb(@ApiParam(required = false, name = "userid", value = "注册手机用户id")@RequestParam("userid")String userid,
//			@ApiParam(required = false, name = "jlbid", value = "俱乐部id信息")@RequestParam("jlbid")String jlbid){
//		
//		JlbUserInfo jui=new JlbUserInfo();
//		jui.setId(UUID.randomUUID().toString());
//		jui.setJlbid(jlbid);
//		jui.setUserid(userid);
//		boolean flag=jlbBaseService.addPeopleInJlb(jui);
//		MbResultData infolist = new MbResultData();
//		if(flag){
//			infolist.setSuccess(1);
//		}else{
//			infolist.setSuccess(0);
//		}
//		infolist.setMsg("查询成功");
//		responseJson(infolist);
//	}
//	
//	@POST
//	@Path(value = "/deletePeopleOutOfJlb")
//	@RequestMapping(value="/deletePeopleOutOfJlb" )
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//	@ApiOperation(value = "删除俱乐部用户", httpMethod = "POST", notes = "删除俱乐部用户",produces="application/json") 
//	@ResponseBody
//	public void  deletePeopleOutOfJlb(@ApiParam(required = false, name = "userid", value = "注册手机用户id")@RequestParam("userid")String userid,
//			@ApiParam(required = false, name = "jlbid", value = "俱乐部id信息")@RequestParam("jlbid")String jlbid){
//		
//		JlbUserInfo jui=new JlbUserInfo();
//		boolean flag=jlbBaseService.deletePeopleOutOfJlb(userid,jlbid);
//		MbResultData infolist = new MbResultData();
//		if(flag){
//			infolist.setSuccess(1);
//		}else{
//			infolist.setSuccess(0);
//		}
//		infolist.setMsg("查询成功");
//		responseJson(infolist);
//	}
//	
	
	
//	public void responseJson(Object o){
//		try {
//			request.setCharacterEncoding("utf-8");
//			response.setContentType("application/json;charset=utf-8");
//			response.getWriter().write(EmiJsonObj.fromObject(o).toString());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	
	
	
}
